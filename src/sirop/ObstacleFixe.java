/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;

import javax.swing.ImageIcon;

/**
 *
 * @author marc
 */
public class ObstacleFixe extends Obstacle {
    
    public ObstacleFixe(int x, int y)
    {
        super(x,y);
    }

    public int getNiveau()
    {
        return 6666666;
    }
    
    @Override
     public void applyEffect(Robot r)
    {
     
    } 

    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/obstaclefixe.png");
    }
    
     
}


