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
public abstract class Obstacle {
    protected int xPos;
    protected int yPos;

    public Obstacle(int _x, int _y)
    {
        this.xPos = _x;
        this.yPos = _y;
    }
    
    /**
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }
}
