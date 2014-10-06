/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;
import java.awt.Color;
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
        RobotCombattant r_c = new RobotCombattant(9,9);
        r_c.setNomRobot("r_c-1");
        
        //init obstacles
        BorneEnergie b_e = new BorneEnergie(1,1);
        
        //init plateau jeu
        PlateauJeu plateau = new PlateauJeu(10, 10);
        plateau.addRobot(r_n);
        plateau.addRobot(r_c);
        plateau.addObstacle(b_e);
        
        // GUI
        rFrame rF = new rFrame(plateau.getHauteur(), plateau.getLargeur());        
        JPanel rPane = rF.getPane();
        JPanel[] cases = rF.getCases();
        
        while(keepPlaying)
        {
            plateau.displayToString();
            Thread.sleep(500);
            plateau.randomMoveRobots();
            plateau.applyBonuses();
            rPane.removeAll();
            plateau.displayPlateau(cases);
            for (int i =  0; i < 100; i++)
            {
                rPane.add(cases[i]);
            }
            rF.repaint();
            rF.setVisible(true);
            //System.out.println("Keep playing (0/1) ?");
            //keepPlaying = s.nextInt()==1;
        }
        
    }
    
}
