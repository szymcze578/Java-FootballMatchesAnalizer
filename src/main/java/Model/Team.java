/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import Exceptions.DividingByZeroException;
import Widok.TeamView;
import java.util.ArrayList;

/**
 * Class that represents model in MVC framework.
 * @author Szymon Czech
 * @version 1.3
 */
public class Team {
     
    /**
     * Name of the team.
     */
    private String name;
    
    /**
     * Number of wins.
     */
    private int wins;
    
    /**
     * Number of loses.
     */
    private int loses;
    
    /**
     * Number of draws.
     */
    private int draws;
    
    /**
     * Number of goals.
     */
    private int goals;
    
    private TeamView singleTeamView;

    /**
     * Constructor method.
     */
    public Team(){}
    
    /**
     * Constructor method.
     * @param name team's name.
     * @param wins number of wins.
     * @param loses number of loses.
     * @param draws number of draws.
     * @param goals number of goals.
     */
    public Team(String name, int wins, int loses, int draws, int goals){
        this.name=name;
        this.wins=wins;
        this.loses=loses;
        this.draws=draws;
        this.goals=goals;
        
    }
    
    /**
     * A method that sets name of the team.
     * @param name team's name.
     */
    public void setName(String name){
        this.name=name;
    }
    
   /**
    * A method that sets the team number of wins.
    * @param wins number of wins.
    */
    public void setWins(int wins){
        this.wins=wins;
    }
    
    /**
     * A method that sets the team number of loses.
     * @param loses number of loses.
     */
    public void setLoses(int loses){
        this.loses=loses;
    }
    
    /**
     * A method that sets the team number of draws.
     * @param draws number of draws.
     */
    public void setDraws(int draws){
        this.draws=draws;
    }
    
    /**
     * A method that sets the team number of goals.
     * @param goals number of goals.
     */
    public void setGoals(int goals){
        this.goals=goals;
    }
    
    /**
     * A method that gets name of the team.
     * @return team's name.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * A method that gets to the user team number of wins.
     * @return number of wins.
     */
    public int getWins(){
        return this.wins;
    }
    
    /**
     * A method that gets to the user team number of loses.
     * @return number of loses.
     */
    public int getLoses(){
        return this.loses;
    }
    
    /**
     * A method that gets to the user team number of draws.
     * @return number of draws.
     */
    public int getDraws(){
        return  this.draws;
    }
    
    /**
     * A method that gets to the user team number of goals.
     * @return number of goals.
     */
    public int getGoals(){
        return  this.goals;
    }
    

    /**
     * A main method that calculates the draws to win percentage ratio of the team. 
     * @return calculated value.
     * @throws Exceptions.DividingByZeroException 
     */
    public float calculateDrawsToWins() throws DividingByZeroException{
       if(this.draws==0 || this.wins ==0){
           throw new DividingByZeroException();
       }
       else{
            float result = ((float)this.draws/(float)this.wins)*100;
            return result;
       }
    }
    
    /**
     * A method that searched for the team with the most wins.
     * @param TeamList List of the teams.
     * @return team with most goals.
     */
    public Team teamWithMostWins(ArrayList<Team> TeamList){
         Team mostWins = new Team();
         int current_wins=0;
         if(!TeamList.isEmpty()){
             for(Team t : TeamList){
                 if(t.getWins()>current_wins){
                     current_wins = t.getGoals();
                     mostWins=t;
                             
                 }
             }   
         }
         return mostWins;
    }
    
    /**
     * A main method that is sorting teams in the list by number of goals.
     * @param TeamList list of teams.
     */
    public void sortListByGoals(ArrayList<Team> TeamList){
         for(int i=0; i< TeamList.size(); i++){  
             for (int j = i+1; j<TeamList.size();j++){

                 Team temp;

                 if(TeamList.get(j).goals > TeamList.get(i).goals){
                     temp = TeamList.get(i);
                     TeamList.set(i,TeamList.get(j));
                     TeamList.set(j, temp);
                 }
             }    
        }              
     }
    
    
    /**
     * A method for searching for a team in the list by given name. Used in calculating ratio method in console version of the aplication.
     * @param TeamList list of the teams.
     * @param name team's name.
     * @return found team.
     */
    public Team searchTeamByName(ArrayList<Team> TeamList, String name){
        
         Team searchedTeam = new Team();
         for(Team t : TeamList){
             if(t.name.equals(name)){
                 searchedTeam=t;
             }
         }
        return searchedTeam;
    }
    
    /**
     * A method for searching for a team in TeamList given by the index of position.
     * @param TeamList list of the teams.
     * @param args indexes of teams in TeamList.
     * @return list of teams.
     */
    public ArrayList showTeamInIndexPosition(ArrayList<Team> TeamList, int... args ){
        
       if(!TeamList.isEmpty()){
           ArrayList<Team> foundTeams;
                  foundTeams = new ArrayList<>();
       for(int i =0; i<args.length;i++){
            if((args[i]-1)<TeamList.size()&& args[i]>0){
                Team teamInIndex;
                teamInIndex = TeamList.get(args[i]-1);
                foundTeams.add(teamInIndex);          
            }
       }
       
       return foundTeams;
       }
       return null;
    }
    
}
