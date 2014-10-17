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
public class ObstacleMobile extends Obstacle implements Movable{
    
    public ObstacleMobile(int x, int y)
    {
        super(x,y);
    }
    
    @Override
    public void setPos(Point2D p)
    {
        this.pos = new Point2D(p);
    }

   @Override
    public void applyEffect(Robot r)
    {
     
    } 
    
    public int getNiveau()
    {
        return 00;
    }
    
    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/old/obstaclemobile.png");
    }
}