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
public abstract class Bonus extends Obstacle {

    public Bonus(int x, int y)
    {
        super(x,y);
    }
    public abstract void applyBonus(Robot r);
    //protected int xPos;
    //protected int yPos;
    
}
