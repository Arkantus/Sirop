/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;
import java.util.Scanner;

import javax.swing.*;


/**
 *
 * @author marc
 */
public class SIROP {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        //init globals
        Scanner s = new Scanner(System.in);
        boolean keepPlaying = true;   
        
        //init robots
        RobotNeuneu r_n = new RobotNeuneu();
        r_n.setNomRobot("r_n-1");
        RobotCombattant r_c_1 = new RobotCombattant(6,7);
        r_c_1.setNomRobot("r_c-1");
        RobotCombattant r_c_2 = new RobotCombattant(6,7);
        r_c_2.setNomRobot("r_c-2");
        RobotCombattant r_c_3 = new RobotCombattant(6,7);
        r_c_3.setNomRobot("r_c-3");
        
        
        //init obstacles
        BorneEnergie b_e = new BorneEnergie(1,1);
        ObstacleFixe o_f = new ObstacleFixe(6,6);
        
        
        //init plateau jeu
        PlateauJeu plateau = new PlateauJeu(10,10);
        plateau.addRobot(r_n);
        plateau.addRobot(r_c_1);
        plateau.addRobot(r_c_2);
        plateau.addRobot(r_c_3);
        plateau.addObstacle(b_e);
        plateau.addObstacle(o_f);
        
        //plateau.addRobot(r_n);
        //plateau.addRobot(r_c);
        //plateau.addObstacle(b_e);
        plateau.resetAll();
        plateau.RestoreState("/home/marc/Downloads/save");
        
        // GUI
        rFrame rF = new rFrame(plateau.getHauteur(), plateau.getLargeur());        
        JPanel rPane = rF.getPane();
        JPanel[] cases = rF.getCases();
        
        while(keepPlaying)
        {
            if (!rF.getIsPaused()){
            //System.out.println(plateau.toString());
            Thread.sleep(500);
            plateau.randomMoveRobots();
            plateau.applyBonuses();
            plateau.displayPlateau(cases);
            rF.refreshGraphics();
            //System.out.println("Keep playing (0/1) ?");
            //keepPlaying = s.nextInt()==1;
            }
            else{rF.refreshGraphics();}
        }
    }
    
}
