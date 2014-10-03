/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;
import java.util.Scanner;
import java.awt.Container;
import java.awt.GridLayout;

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
        
        // GUI
        JFrame boardWindow = new JFrame();
        boardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Container pane = new JPanel(new GridLayout(25,25,0,0));
        ImageIcon icons[] = new ImageIcon[9];
        icons[0] = new ImageIcon("res/robotneuneu.png");
        icons[1] = new ImageIcon("res/robotcombattant.png");
        icons[2] = new ImageIcon("res/robotenergivore.png");
        icons[3] = new ImageIcon("res/borneenergie.png");
        icons[4] = new ImageIcon("res/bornesante.png");
        icons[5] = new ImageIcon("res/obstaclefixe.png");
        icons[6] = new ImageIcon("res/obstaclemobile.png");
        icons[7] = new ImageIcon("res/spybot.png");
        icons[8] = new ImageIcon("res/bg.png");
        JLabel labels[] = new JLabel[625];

        for (int i =  0; i < 625; i++)
        {
            labels[i] = new JLabel( icons[8] );
            pane.add(labels[i]);
        }
        boardWindow.add(pane);
        boardWindow.pack();
        boardWindow.setBounds(10, 10, 800, 800);
        
        
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
        
        while(keepPlaying)
        {
            //plateau.displayToString();
            Thread.sleep(300);
            plateau.randomMoveRobots();
            plateau.applyBonuses();
            pane.removeAll();
            plateau.displayPlateau(labels, icons);
            for (int i =  0; i < 625; i++)
            {
                pane.add(labels[i]);
            }
            boardWindow.repaint();
            boardWindow.setVisible(true);
            //System.out.println("Keep playing (0/1) ?");
            //keepPlaying = s.nextInt()==1;
        }
        
    }
    
}
