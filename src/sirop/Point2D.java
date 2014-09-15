/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

/**
 *
 * @author IAZERTYUIOPI
 */
public class Point2D {
    private int x;
    private int y;
    
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;         
    }
    
    public Point2D(Point2D p, int direction)
    {
       int deltax = 0;
       int deltay = 0;
         
        switch(direction){
            case 0: 
                deltax = 1;
                deltay = 0;
                break;
            case 1: 
                deltax = 1;
                deltay = 1;
                break;
            case 2: 
                deltax = 0;
                deltay = 1;
                break;
            case 3: 
                deltax = -1;
                deltay = 1;
                break;
            case 4: 
                deltax = -1;
                deltay = 0;
                break;
            case 5: 
                deltax = -1;
                deltay = -1;
                break;    
            case 6: 
                deltax = 0;
                deltay = -1;
                break;    
            case 7: 
                deltax = 1;
                deltay = -1;
                break;
        }
        
        this.x = p.x + deltax;
        this.y = p.y + deltay;
    }
    
    public Point2D(Point2D p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isEqual(Point2D p)
    {
        return x == p.y && x == p.y;
    }
    
    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
    
    @Override
    public String toString()
    {
        return "("+this.x+","+this.y+")";
    }
    
}
