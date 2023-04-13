/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Kontroler;

import Exceptions.DividingByZeroException;
import Model.Team;
import Widok.TeamView;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that represents controller in MVC framework.
 * @author Szymon Czech
 * @version 1.3
 */

public class TeamController{
    
      /**
       * Interface between application and user.
       */
      private TeamView view;
      
      /**
       * Interface between controller and model-team.
       */
      private Team model;
      
      /**
       * Container for the objects of Team.
       */
      private ArrayList<Team> TeamList;
      
      public TeamController(){

          this.model = new Team();
          this.TeamList = new ArrayList<>();    
          this.view = new TeamView();
          
          this.view.addButtonListener(new AddButtonListener());
          this.view.sortButtonListener(new SortButtonListener());
          this.view.MostWinsButtonListener(new MostWinsButtonListener());
          this.view.CalculateRatioButtonListener(new CalculateRatioButtonListener());
      }
      
      /**
       * A method to show info abaout the team. It calls the view method.
       * @param t team.
       */
      public void showView(Team t){
          view.showTeamInfo(t.getName(), t.getWins(), t.getLoses(), t.getDraws(),t.getGoals());
      }
        
      /**
       * A method that activates the main menu of the program.
       * It firstly shows menu and then allows user to choose
       * what he/she wants to do by choosing certain options.
       */
     public void activateMenu() {
         
         int option = 0;
         
         while(option !=7){
             
            view.showMenu();
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            
            switch(option){
                    case 1:
                        this.addTeamToList();
                        break;
                    case 2:   
                        this.printTeamList(); 
                        break;
                    case 3:
                        this.TeamWithMostWins();
                        break;
                    case 4:
                        this.calculateRatio();
                        break;
                    case 5:
                        this.sortTeamsByGoals();
                        break;
                    case 6:
                        this.showTeamInIndex();
                        break;
                    case 7:
                        break;
                    default:
                        break;
            }
                        
         }
     }
     
     /**
      * A method that sets team's name.
      * @return team's name.
      */
     private String setName(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
     }
    
     /**
      * A method that sets teams number of wins.
      * @return number of wins.
      */
    private int setWins(){
        Scanner scanner = new Scanner(System.in);
        int wins = scanner.nextInt();
        return wins;
     }
    
    /**
     * A method that sets teams number of loses.
     * @return number of loses.
     */
     private int setLoses(){
        Scanner scanner = new Scanner(System.in);
        int loses = scanner.nextInt();
        return loses;
     }
     
     /**
      * A method that sets teams number of draws.
      * @return number of draws.
      */
     private int setDraws(){
        Scanner scanner = new Scanner(System.in);
        int draws = scanner.nextInt();
        return draws;
     }
     
     /**
      * A method that sets teams number of goals.
      * @return number of goals.
      */
     private int setGoals(){
        Scanner scanner = new Scanner(System.in);
        int goals = scanner.nextInt();
        return goals;
     }
     
     /**
      * A method that allows user to add team to the list. It calls view methods,
      * and model methods to set team's name, number of wins, loses, draws and goals.
      */
     private void addTeamToList(){
         Team team = new Team();
         
         view.setTeamName();
         team.setName(setName());
         
         view.setTeamWins();
         team.setWins(setWins());
         
         view.setTeamLoses();
         team.setLoses(setLoses());
         
         view.setTeamDraws();
         team.setDraws(setDraws());
         
         view.setTeamGoals();
         team.setGoals(setGoals());
         
         TeamList.add(team); 
     }
      
     /**
      * A method that prints the entire list of teams.
      */
     private void printTeamList(){
        if(!TeamList.isEmpty()){
            view.showOrder();
            for(Team t : TeamList){
                    this.showView(t);
            }
        }
        else
            view.TeamListEmptyMessage();
     }
     
     /**
      * A method that creates and adds five exmaple teams to the list.
      */
     private void addExampleTeams(){
         
        Team team1 = new Team("Liverpool",247,43,23,356);
        TeamList.add(team1);
                        
        Team team2 = new Team("FC Barcelona",354, 35, 47, 674);
        TeamList.add(team2);
                        
        Team team3 = new Team("Real Madrit" ,365, 67, 67, 876);
        TeamList.add(team3);
                        
        Team team4 = new Team("Manchaster UTD", 254, 127, 67, 587);
        TeamList.add(team4);
        
        view.showSuccesMessage();
     }
     
     
     /**
      * A method that is calls the method to add teams from TeamList to JTable model.
      */
     private void addTeams(){
         if(TeamList.isEmpty()){
            try{
            this.importData();
            view.addToTable(TeamList);
            }
            catch(CsvValidationException | IOException e){
                System.out.println("Failed to import teams from file.");
            }
         }
         else{
             //view.alreadyAddedMessage();
             view.addToTable(TeamList);
         }
         
     }
     
     /**
      * A method that import data form csv file with matches statistics.
      * It parses the data and loads it to TeamList.
      * @throws IOException
      * @throws CsvValidationException 
      */
     private void importData() throws IOException,CsvValidationException {
         try {
             CSVReader reader = new CSVReader(new FileReader("eplmatches.csv"));
             
             String []firstline = reader.readNext();
             
             String [] nextLine;
             while((nextLine= reader.readNext())!=null){
                 String home = nextLine[3];
                 int homeGoals = Integer.parseInt(nextLine[4]);
                 int awayGoals = Integer.parseInt(nextLine[5]);
                 String away = nextLine[6];
                 String whoWon = nextLine[7];
                 
                 //Team homeTeam = new Team();
                 //Team awayTeam = new Team();
                 Team homeTeam = model.searchTeamByName(TeamList, home);
                 Team awayTeam = model.searchTeamByName(TeamList, away);
                 
                 if(homeTeam.getName()==null){
                     homeTeam = new Team(home,0,0,0,0);
                     TeamList.add(homeTeam);
                 }
                 if(awayTeam.getName()==null){
                     awayTeam = new Team( away, 0,0,0,0);
                     TeamList.add(awayTeam);         
                 }
                 
                 homeTeam.setGoals(homeTeam.getGoals()+homeGoals);
                 awayTeam.setGoals(awayTeam.getGoals()+awayGoals);
                               
                 switch(whoWon){
                     case "H" -> {
                         homeTeam.setWins(homeTeam.getWins()+1);
                         awayTeam.setLoses(awayTeam.getLoses()+1);
                     }
                     case "A" -> {
                         awayTeam.setWins(awayTeam.getWins()+1);
                         homeTeam.setLoses(homeTeam.getLoses()+1);
                     }
                     case "D" -> {
                         homeTeam.setDraws(homeTeam.getDraws()+1);
                         awayTeam.setDraws(awayTeam.getDraws()+1);
                     }           
                 }
                 
                 for(int i =0; i<TeamList.size();i++){
                     if(TeamList.get(i).getName().equals(homeTeam.getName()))
                         TeamList.set(i,homeTeam);
                     if(TeamList.get(i).getName().equals(awayTeam.getName()))
                        TeamList.set(i,awayTeam);
                 } 
             }
         }
         catch(CsvValidationException e){
           //  e.printStackTrace();
         }
     }
     
     /**
      * A method that searched for the team with the most wins.It calls model method and then the result
      * is shown to user.
      */
     public void TeamWithMostWins(){
            if(!TeamList.isEmpty()){
            Team mostWins = model.teamWithMostWins(TeamList);
            view.returnMostWins(mostWins.getName(),mostWins.getWins());
            }
            else{
                view.emptyListPane();
            }
     }
     
     
     @Deprecated
     /**
      * A method that calculates draws to wins ratio. It allows user to enter
      * team name and then calls model method to calculate ratio. Then result
      * is shown to user.
      */
     private void calculateRatio(){
         view.chooseTeamMessage();
         Scanner scanner = new Scanner(System.in);
         String name = scanner.nextLine();
         
         
         Team searchedTeam = model.searchTeamByName(TeamList, name);
         if(searchedTeam.getName()==null){
             view.teamNotFoundMessage();
         }
         else{
             try{
                float result = searchedTeam.calculateDrawsToWins(); 
                view.showWinDrawsStats(searchedTeam.getName(), result);
             }
             catch(DividingByZeroException d){
                 System.out.println(d.getMessage());
             }
         }
     }
     
     /**
     * A new implementation of method that calculates draws to wins ratio.
     * It calculates ratio given by row number selected in the table.If the row is not selected, then proper information is given to the user.
     * And also when the list of teams is empty the information is given to the user.
     */
     private void calculateRatioGUI(){
            if(!TeamList.isEmpty()){
                int row = view.getClickedRow();
                if(row != -1){
                try{
                    Team searchedTeam = model.searchTeamByName(TeamList, TeamList.get(row).getName());
                    Float ratio = searchedTeam.calculateDrawsToWins();
                    view.returnDrawsToWins(TeamList.get(row).getName(), ratio);
                }
                catch(DividingByZeroException error){
                    view.dividingWarning();
                }
                }
                else{
                    view.selectRowWarning();
                }
            }
            else{
                view.emptyListPane();
            }
     }
     
     
     /**
      * A method that is sorting teams in the list by number of goals. It calls model main method to sort teams.
      */
    public void sortTeamsByGoals(){   
         if(!TeamList.isEmpty()){
             if(TeamList.size()>2){
                 model.sortListByGoals(TeamList);
                 //view.showSuccesMessage();
             }
             else{
                 //view.showSuccesMessage();
             }
         }
         else{
             view.emptyListPane();
         }
     }
     
    /**
     * A method to show information about maximum up to 3 teams.
     */
    public void showTeamInIndex(){

        if(TeamList.isEmpty()){
            view.TeamListEmptyMessage();
        }
        else{
        
        ArrayList<Team> foundTeams = new ArrayList<>();
            
        view.showInfoAboutMethod();
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
        
        if(howMany >3){
            System.out.println("Too many teams.");
        }
        else if(howMany == 1){
            view.typeFirstIndex();
            int first = scanner.nextInt();
            foundTeams = model.showTeamInIndexPosition(TeamList,first);
        }
        else if(howMany ==2){
            view.typeFirstIndex();
            int first = scanner.nextInt();
            view.typeSecondIndex();
            int second = scanner.nextInt();
            foundTeams = model.showTeamInIndexPosition(TeamList,first, second);
        }
        else if(howMany ==3){
            view.typeFirstIndex();
            int first = scanner.nextInt();
            view.typeSecondIndex();
            int second = scanner.nextInt();
            view.typeThirdIndex();
            int third = scanner.nextInt();
            foundTeams = model.showTeamInIndexPosition(TeamList,first, second,third);
        }
        
        for(Team t :foundTeams){
            this.showView(t);
        }
        
        }
    }

    /**
     * An inner class to handle the event of pressing button that is adding teams.
     */
    class AddButtonListener implements ActionListener {
        
        @Override
        /**
         * Overrided method that calls method to adds teams to the list.
         */
        public void actionPerformed(ActionEvent e){
            addTeams();
        }
    
    }

    /**
     * An inner class to handle the event of pressing button that sorting teams in the list by most goals.
     */
    class SortButtonListener implements ActionListener{
        
        @Override
        /**
         * Overrided method that calls method to sort teams in the list. After that JTable is cleared and teams are added again.
         */
        public void actionPerformed(ActionEvent e){
            sortTeamsByGoals();
            view.removeModel();
            view.addToTable(TeamList);
        }
    }
    
    /**
     * An inner class to handle the event of pressing button that shows the team which won most games.
     */
    class MostWinsButtonListener implements ActionListener{
        
        @Override
        /**
         * Overrided method to show team with most wins. When list of the team is empty it shows to proper information.
         */
        public void actionPerformed(ActionEvent e){
            TeamWithMostWins();
        }
    }
    

    /**
     * An inner class to handle the event of pressing button to calculate draws to wins ratio of the selected team.
     */
    class CalculateRatioButtonListener implements ActionListener {
        
        @Override
        /**
         * Overrided method to calculate draws to wins ratio. 
         */
        public void actionPerformed(ActionEvent e){
            calculateRatioGUI();
        }
    
    }
    
}
