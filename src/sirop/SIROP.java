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

        
        // GUI
        rFrame rF = new rFrame(plateau.getHauteur(), plateau.getLargeur(),plateau);        
        JPanel rPane = rF.getPane();
        JPanel[] cases = rF.getCases();
        
        //gestion du menu
        reactionMenu rM = new reactionMenu(rF);
        
        while(keepPlaying)
        {
            plateau.saveState(cnp + "_Save_");
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
