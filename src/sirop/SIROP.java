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
        RobotCombattant r_c = new RobotCombattant(24,24);
        r_c.setNomRobot("r_c-1");
        
        //init obstacles
        BorneEnergie b_e = new BorneEnergie(1,1);
        
        //init plateau jeu
        PlateauJeu plateau = new PlateauJeu(25, 25);
        plateau.addRobot(r_n);
        plateau.addRobot(r_c);
        plateau.addObstacle(b_e);
        
        // GUI
        rFrame rF = new rFrame(plateau.getHauteur(), plateau.getLargeur());        
        JPanel rPane = rF.getPane();
        JLabel[] labels = rF.getLabels();
        
        while(keepPlaying)
        {
            //plateau.displayToString();
            Thread.sleep(300);
            plateau.randomMoveRobots();
            plateau.applyBonuses();
            rPane.removeAll();
            plateau.displayPlateau(labels);
            for (int i =  0; i < 625; i++)
            {
                rPane.add(labels[i]);
            }
            rF.repaint();
            rF.setVisible(true);
            //System.out.println("Keep playing (0/1) ?");
            //keepPlaying = s.nextInt()==1;
        }
        
    }
    
}
