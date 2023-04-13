/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Package contains view of the MVC framework of the aplication. View represents the visualization of the data that model contains.
 */
package Widok;

import Model.Team;

import java.awt.*;
import javax.swing.*;


//import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;


/**
 * Class that represents view in MVC framework.
 * @author Szymon Czech
 * @version 1.3
 */
public class TeamView  extends javax.swing.JFrame{
    
    /**
     * Button for sorting table functionality.
     */
    private javax.swing.JButton SortButton;
    
    /**
     * Button for addint teams functionality.
     */
    private javax.swing.JButton AddButton;
    
    /**
     * Button for searching for team with most wins functionality.
     */
    private javax.swing.JButton MostWinsButton;
    
    /**
     * Button for calculating ratio functionality.
     */
    private javax.swing.JButton CalculateRatioButton;
    
    /** 
     * JTable component to storage data. 
     */
    private javax.swing.JTable TeamsTable;
    
    /**
     * Scroll Panle component used for the table.
     */
    private javax.swing.JScrollPane jScrollPane1;

    /**
     * Logo of the Champions League.
     */
    private javax.swing.JLabel Logo;
    
    /**
     * Aplication main title label.
     */
    private javax.swing.JLabel Title;
   
    
    /**
     * TeamView constructor that initialize all the components and makes them visible
     */
    public TeamView() {
        initComponents();
        setVisible(true);
    }


    /**
     * A method that initialize all the components.
     */
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TeamsTable = new javax.swing.JTable();
        SortButton = new javax.swing.JButton();
        MostWinsButton = new javax.swing.JButton();
        CalculateRatioButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        
        setupLogo();
        setupTitleLabel();
        
        SortButton.setText("Sort");
        MostWinsButton.setText("Most wins");
        CalculateRatioButton.setText("Calculate ratio");
        AddButton.setText("Add teams");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Champions League Matches Analizer");
        setResizable(false);
        
        TeamsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "Name", "Wins", "Loses", "Draws", "Goals"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TeamsTable);
     
        setupLayout();
        
        
    }    
    
    /**
     * A method that sets up label that shows the title of the aplication.
     */
    private void setupTitleLabel(){
        Title.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Champions League analizer 1992-2022");
        Title.setToolTipText("");
        Title.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Title.setName(""); // NOI18N
    }
    
    /**
     * Setting up frame lauout.
     */
    private void setupLayout(){
        
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CalculateRatioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MostWinsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(39, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(SortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(MostWinsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(CalculateRatioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(27, 27, 27))
            );

        pack();
    }
    
    
    /**
     * Seting up Champions League logo icon
     */
    private void setupLogo(){
       
        ImageIcon clLogo = new ImageIcon("LOGO.svg.png");
        Image image = clLogo.getImage().getScaledInstance(80, 80,java.awt.Image.SCALE_SMOOTH);
        clLogo = new ImageIcon(image);
        Logo = new javax.swing.JLabel(clLogo,JLabel.CENTER);
        
    }
    
    /**
     * A method that adds listener for add teams button.
     * @param listenForAddButton 
     */
    public void addButtonListener(ActionListener listenForAddButton){
        AddButton.addActionListener(listenForAddButton);
    }
    
    /**
     * A method that adds listener for sort button.
     * @param listenForSortButton 
     */
    public void sortButtonListener(ActionListener listenForSortButton){
        SortButton.addActionListener(listenForSortButton);
    }
    
    /**
     * A method that adds listener for most wins button.
     * @param listenForMostWinsButton 
     */
    public void MostWinsButtonListener(ActionListener listenForMostWinsButton){
        MostWinsButton.addActionListener(listenForMostWinsButton);
    }
    
    /**
     * A method that adds listener for calculate ratio button.
     * @param listenForCalculateRatioButton 
     */
    public void CalculateRatioButtonListener(ActionListener listenForCalculateRatioButton){
        CalculateRatioButton.addActionListener(listenForCalculateRatioButton);
    }
    
    /**
     * A method that returns the index of the row clicked in the table.
     * @return index of selected row.
     */
    public int getClickedRow(){     
       int row = TeamsTable.getSelectedRow();
       return row;
    }
    
    /**
     * A method that show a message pane what user did not choose row in the table.
     */
    public void selectRowWarning(){
        JOptionPane.showMessageDialog(this.rootPane, "Select row first!", "ERROR: Row not selected", 0);
    }
    
    /**
     * A method that show a message pane with team that have the most team.
     * @param name team's name.
     * @param wins number of wins.
     */
    public void returnMostWins(String name,int wins){
        JOptionPane.showMessageDialog(this.rootPane,"Team with most wins: "+ name + ". Wins: " + wins);
    }
    
    /**
     * A method that show a message pane with calculated draws to wins ratio for specific team.
     * @param name team's name.
     * @param ratio calculated ratio.
     */
    public void returnDrawsToWins(String name, float ratio){    
        JOptionPane.showMessageDialog(this.rootPane, name + " draws to wins ratio: "+String.format("%.2f", ratio) +"%.", "Calculated Ratio ",1); 
    }
    
    /**
     * A method that shows a message pane about dividing by zero.
     */
    public void dividingWarning(){
        JOptionPane.showMessageDialog(this.rootPane, "Error: Dividing by zero", "Exception: Dividing by zero", 0);
    }
    
    /**
     * A method that shows a message pane about empty list.
     */
    public void emptyListPane(){
        JOptionPane.showMessageDialog(this.rootPane, "List of teams is empty", "ERROR: Empty team list", 0);
    }
    
    /**
     * Method that clears the JTable model.
     */
    public void removeModel(){
        DefaultTableModel model = (DefaultTableModel)TeamsTable.getModel();
        model.setRowCount(0);
    }
    
    /**
     * A method that adds teams form the list to JTable.
     * @param List list of the Teams.
     */
    public void addToTable(ArrayList<Team> List){
        DefaultTableModel model = (DefaultTableModel)TeamsTable.getModel();
        if(model.getRowCount()==0){
            for(Team t: List){
                Vector rowOfData= new Vector();
                rowOfData.add(t.getName());
                rowOfData.add(t.getWins());
                rowOfData.add(t.getLoses());
                rowOfData.add(t.getDraws());
                rowOfData.add(t.getGoals());
                model.addRow(rowOfData);
            }
        }
        else{
            JOptionPane.showMessageDialog(this.rootPane,
                    "Teams already added");
        }
    }
 
    /**
     * Method that is showing the order of the information that are shown in showTeamInfoMethod.
     */
    public void showOrder(){
        System.out.format("%-16s%-7s%-7s%-7s%-7s\n", "Name", "Wins",  "Loses",  "Draws",  "Goals");
    }
    
    /**
     * Method that is showing information about certain team.
     * @param name team's name.
     * @param wins number of games won.
     * @param loses number of games lost.
     * @param draws number of draws.
     * @param goals number of goals scored by the team.
     */
    public void showTeamInfo(String name, int wins, int loses, int draws,int goals){
        System.out.format("%-16s%-7d%-7d%-7d%-7d\n", name, wins, loses, draws, goals);
    }
    
    
    /**
     * A method that shows a line to enter the name of a team.
     */
    public void setTeamName(){
        System.out.println("Type team name: ");
    }
    
    /**
     * A method that shows a line to enter the number of wins of a team.
     */
    public void setTeamWins(){
        System.out.println("Type team wins: ");
    }
    
    /**
     * A method that shows a line to enter the number of draws of a team.
     */
    public void setTeamDraws(){
        System.out.println("Type team draws: ");
    }
    
    /**
     * A method that shows a line to enter the number of loses of a team.
     */
    public void setTeamLoses(){
        System.out.println("Type team loses: ");
    }
       
    /**
     * A method that shows a line to enter the number of goals of a team.
     */
    public void setTeamGoals(){
        System.out.println("Type team goals: ");
    }
    


    /**
     * Method that types line, and statistics about draws to wins percentage ratio of certain team.
     * @param name team's name.
     * @param ratio team's draw to win percentage ratio.
     */
    public void showWinDrawsStats(String name, float ratio){
        System.out.println("Draws to Wins ratio for "+ name +": " +String.format("%.2f", ratio) +"%.");
    }
    
    /**
     * Method that shows menu to the user. 
     */
    public void showMenu(){
        this.showSeparatingLine();
        System.out.println("Choose your destiny:");
        System.out.println("1. Add a team to the database");
        System.out.println("2. Show teams ");
        System.out.println("3. Show team with most wins");
        System.out.println("4. Calculate percentage ratio(draws to wins)");
        System.out.println("5. Sort teams by goals");
        System.out.println("6. Show team in index numbers");
        System.out.println("7. Exit");
        this.showSeparatingLine();
        this.showUserChoice();
    }
    
    /**
     * A method that types separating line to choose team's name.
     */
    public void showSeparatingLine() {
        System.out.println("---------------------------------");
    }
    
    /**
     * A method that types line to choose one option from menu.
     */
    public void showUserChoice() {
        System.out.print("I choose option: ");
    }

    /**
     * A method that types line that operation was succesfull.
     */
    public void showSuccesMessage() {
        System.out.println("Operation Succesfull");
    }
    
    
    /**
     * A method that types line that list of elements is empty.
     */
    public void TeamListEmptyMessage(){
        System.out.println("List of the teams is empty.");
    }

    
    /**
     * A method that types line to choose team's name.
     */
    public void chooseTeamMessage() {
        System.out.println("Type team's name:");
    }
    
    /**
     * A method that types line if the team don't exist in the list.
     */
    public void teamNotFoundMessage(){
        System.out.println("Team not found!");
    }
        
    /**
     * A method that shows information about how to use function.
     */
    public void showInfoAboutMethod(){
        System.out.println("You can only show information about 3 teams maximum. How many teams you want: ");
    }
    
    /**
     * A method that shows a line to enter the index of first team.
     */
    public void typeFirstIndex(){
        System.out.println("Index of first team:");
    }
    
    /**
     * A method that shows a line to enter the index of second team.
     */
    public void typeSecondIndex(){
        System.out.println("Index of second team:");
    }
     
    /**
     * A method that shows a line to enter the index of third team.
     */
    public void typeThirdIndex(){
        System.out.println("Index of third team:");
    }
    
    /**
     * A method that shows a line that teams are already added.
     */
    public void alreadyAddedMessage(){
        System.out.println("Teams already added.");
    }
}



    