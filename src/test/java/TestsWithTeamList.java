/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//import org.junit.jupiter.api.*;
import Model.Team;
import java.util.ArrayList;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Szymon Czech
 */
public class TestsWithTeamList {
    
    /**
     * Container for the objects of teams.
     */
    private ArrayList<Team>  TestedList = new ArrayList<>() ;
    
    /**
     * A method that set ups the list of teams.
     */
    @BeforeEach
    public void SetUp(){
        Team team1 = new Team("Liverpool",247,43,23,356);
        TestedList.add(team1);
        Team team2 = new Team("FC Barcelona",354, 35, 47, 674);
        TestedList.add(team2);
        Team team3 = new Team("Real Madrit" ,365, 67, 67, 876);
        TestedList.add(team3);                
        Team team4 = new Team("Manchester UTD", 254, 127, 67, 587);
        TestedList.add(team4);
    }
    

    /**
     * A method that tests with false values the correctness of a method that returns the team with the most number of wins.
     * @param wins number of wins
     */
    @ParameterizedTest
    @ValueSource(ints ={365,247,254,354})
    public void teamWithMostWinsTest(int wins){
        
        Team mostSuccessFullTeam = new Team();
        if(wins ==365){
            assertEquals(wins,mostSuccessFullTeam.teamWithMostWins(TestedList).getWins(),"NOT EQUAL, TEST FAILED" );
        }
        else{
        assertNotEquals(wins,mostSuccessFullTeam.teamWithMostWins(TestedList).getWins(),"EQUAL, TEST FAILED" );
        }
    }
    
    /**
     * A method that tests the correctness of searching for the team method.
     * @param name name of the team.
     */
    @ParameterizedTest
    @ValueSource(strings ={"FC Barcelona", "Liverpool","Real Madrit", "Manchester UTD"})
    public void searchForTeamTest(String  name){
        
        Team searchedTeam = new Team();
        
        searchedTeam = searchedTeam.searchTeamByName(TestedList, name);
        assertEquals(name,searchedTeam.getName(),"NOT EQUAL");
    }
    
    /**
     * A method that tests the correctness of searching for the team method with incorrect values.
     * @param name name of the team.
     */
    @ParameterizedTest
    @ValueSource(strings ={"Legia", "Liverpoool"})
    public void searchForTeamTestFalseValues(String  name){
        
        Team searchedTeam = new Team();
        
        searchedTeam = searchedTeam.searchTeamByName(TestedList, name);
        assertNotEquals(name,searchedTeam.getName(),"NOT EQUAL");
    }
    
    
    /**
     * A method that tests the correctness of the team list sorting method.
     * @param name name of the team.
     * @param index index of the list.
     */
    @ParameterizedTest
    @MethodSource("provideParameters")
    public void sortTeamsTest(String name,int index){
        
        Team model = new Team();
        model.sortListByGoals(TestedList);
        
        assertEquals(name,TestedList.get(index).getName(),"NOT EQUAL"); 
    }
    
    /**
     * Arguments provider.
     * @return Stream of arguments.
     */
    private static Stream<Arguments> provideParameters() {
    return Stream.of(
            Arguments.of("Real Madrit", 0),
            Arguments.of("FC Barcelona", 1),
            Arguments.of("Manchester UTD", 2),
            Arguments.of("Liverpool" , 3)
    );
   
}   /**
     * A method that is testing the behaviour of searching team by index in the table method with valse values.
     * @param index index of the team.
    */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void searchTeamByIndexTest(int index){
        Team searchedTeam = new Team();
        assertNotNull(searchedTeam.showTeamInIndexPosition(TestedList, index), "Is null");
    }
    
    /**
     * A method that is testing the behaviour of searching team by index in the table method with valse values.
     * @param index index of the team.
     */
    @ParameterizedTest
    @ValueSource(ints = {0,6,-1})
    public void searchTeamByIndexTestFalseValues(int index){
        Team searchedTeam = new Team();
        ArrayList<Team> list = searchedTeam.showTeamInIndexPosition(TestedList, index);
        assertTrue(list.isEmpty(), "List not empty");
    }
      
}
