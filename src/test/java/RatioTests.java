/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//import org.junit.jupiter.api.*;
import Exceptions.DividingByZeroException;
import Model.Team;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Szymon Czech
 */

public class RatioTests {
    

    private Team team ;
    //private Team zero ;
    
    @BeforeEach
    public void setUp(){
        team = new Team("Barcelona",100,25,50,354);
        //zero = new Team ("Real",123,50,0,23);
    }
    
    /**
     * A method that test behaviour of ratioCalculation method.
     * @throws DividingByZeroException 
     */
    @Test
    public void testRatioCalculation() throws DividingByZeroException {
        try{
        assertEquals(50.0,team.calculateDrawsToWins(), 0.1 );
        }
        catch(DividingByZeroException e){
            fail("Dividing by zero");
        }
    }
    
    /**
     * A method that test behaviour of ratioCalculation method.
     * @param draws number of draws.
     * @throws DividingByZeroException 
     */
    @ParameterizedTest
    @ValueSource(ints = {123,432,0,212})
    public void testRatioCalculationWithZeroDraws(int draws) throws DividingByZeroException{
        team.setDraws(draws);
        if(draws ==0){
            Exception exc = assertThrows(DividingByZeroException.class,()->team.calculateDrawsToWins());
            assertEquals("Error: Trying to calculate ratio for team with zero draws/wins",exc.getMessage(),"Exception NOT Thrown");
        }
        else{
            assertDoesNotThrow(()->team.calculateDrawsToWins(),"Exception Thrown");
        }
    }
    
    /**
     * A method that test behaviour of ratioCalculation method.
     * @param wins number of wins.
     * @throws DividingByZeroException 
     */
    @ParameterizedTest
    @ValueSource(ints = {536,0,21,87})
    public void testRatioCalculationWithZeroWins(int wins) throws DividingByZeroException{
        team.setWins(wins);
        if(wins==0){
            Exception exc = assertThrows(DividingByZeroException.class,()->team.calculateDrawsToWins());
            assertEquals("Error: Trying to calculate ratio for team with zero draws/wins",exc.getMessage());
        }
        else{
            assertDoesNotThrow(()->team.calculateDrawsToWins(),"Exception Thrown");
        }

    }
}
