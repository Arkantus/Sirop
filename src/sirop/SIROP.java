/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;

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
        
        PlateauJeu plateau = new PlateauJeu(50, 50);
        
        RobotNeuneu r_n = new RobotNeuneu();
        r_n.setNomRobot("Je suis CACA !");
        
        BorneEnergie b_e = new BorneEnergie(1,1);
        
        plateau.addRobot(r_n);
        plateau.addObstacle(b_e);
        
        plateau.displayPlateau();
        plateau.moveRobot(0, r_n);
        plateau.displayPlateau();
        
        //jaime la saucisse
    }
    
}
