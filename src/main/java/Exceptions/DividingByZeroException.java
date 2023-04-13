/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *  Class that throws excepthion when user tries to divide by zero.
 * @author Szymon Czech
 * @version 1.1
 */
public class DividingByZeroException extends Exception{
    
    
    public DividingByZeroException(){};
    
    /**
     *  Message about the error.
     * 
     * @return message for the user
     */
    @Override
    public String getMessage(){
        return "Error: Trying to calculate ratio for team with zero draws/wins";
    }
}
