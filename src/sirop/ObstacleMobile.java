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
public class ObstacleMobile extends Obstacle {
    
    public ObstacleMobile(int _x, int _y)
    {
        super(_x,_y);
    }
    
    public void setxPos(int _x)
    {
        this.xPos = _x;
    }
    
    public void setyPos(int _y)
    {
        this.yPos = _y;
    }
    
    public void move()
    {
        //TODO de case en case.
    }
    
}