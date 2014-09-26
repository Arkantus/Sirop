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
public abstract class Obstacle implements ObjectLocalised{
    protected Point2D pos;

    public Obstacle(int x, int y)
    {
        pos = new Point2D(x,y);
    }
    
    /**
     * @return the position
     */
    @Override
    public Point2D getPos() {
        return pos;
    }

    
    @Override
    public String toString()
    {
        return ("\tJe suis de type : " + this.getClass().toString().substring(12) + "\n\tPosition : " + this.pos.toString());
    }
}
