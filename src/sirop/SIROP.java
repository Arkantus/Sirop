/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;
import java.util.Scanner;

/**
 *
 * @author marc
 */
public class SIROP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //init globals
        Scanner s = new Scanner(System.in);
        boolean keepPlaying = true;   
        
        //init robots
        RobotNeuneu r_n = new RobotNeuneu();
        r_n.setNomRobot("Je suis CACA !");
        
        //init obstacles
        BorneEnergie b_e = new BorneEnergie(1,1);
        
        //init plateau jeu
        PlateauJeu plateau = new PlateauJeu(50, 50);
        plateau.addRobot(r_n);
        plateau.addObstacle(b_e);
        
        while(keepPlaying)
        {
            plateau.displayToString();
            plateau.randomMoveRobots();
            plateau.applyBonuses();
            System.out.println("Keep playing (0/1) ?");
            keepPlaying = s.nextInt()==1;
        }
        
    }
    
}
