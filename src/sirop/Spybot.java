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
public class Spybot extends Obstacle implements Movable{
    
    public Spybot(int x, int y)
    {
        super(x,y);
    }
    
    @Override
    public void setPos(Point2D p)
    {
        this.pos = new Point2D(p);
    }

    @Override
    public Point2D getPos()
    {
        return pos;
    }
}
