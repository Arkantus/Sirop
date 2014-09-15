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
    
    public ObstacleMobile(int x, int y)
    {
        super(x,y);
    }
    
    public void setPos(Point2D p)
    {
        this.pos = new Point2D(p);
    }
    
    public void move()
    {
        //TODO de case en case.
    }
    
}