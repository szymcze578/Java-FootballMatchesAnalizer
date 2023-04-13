/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.szymonczechmeczelm;

import Kontroler.TeamController;

/**
 * The entry point of the aplication.
 * @author Szymon Czech
 * @version 1.2
 */
public class SzymonCzechMeczeLM {

    /**
     * 
     * @param args arg[0] is the name of the user.
     */
    public static void main(String[] args) {

        TeamController controller = new TeamController();
        
        if(args.length ==0){
            //System.out.println("Welcome in Champions league analizer!");
            //controller.activateMenu();
        }
        else{
            //System.out.println("Welcome "+ args[0]+ " in Champions league analizer!");
            //controller.activateMenu();
        }
         
    }
   
}
