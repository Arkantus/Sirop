/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author IAZERTYUIOPI
 */
public class reactionMenu implements ActionListener {

private final rFrame gui;
private final PlateauJeu plateau;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
        if(!gui.getIsPaused()){
            System.out.println("Please Pause the simulation before attempting to use this menu.");
        }
        else{
            if(ae.getSource().toString().equals("o")){

                plateau.RestoreState("res/save.txt");

            }
            if(ae.getSource().toString().equals("s")){

                plateau.saveState("res/save.txt");

            }
            if(ae.getSource().toString().equals("t")){

               plateau.resetAll();

            }
        }
    }
    
    public reactionMenu(rFrame rF)
    {
        gui = rF;
        plateau = rF.getPlat();
    }
}
