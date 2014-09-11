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
public class BorneSante extends Bonus {
    
    private static final int SANTEINITIALEBORNE = 100;
    private int santeBorne;

    public BorneSante(int _x, int _y)
    {
        super(_x,_y);
        this.santeBorne = SANTEINITIALEBORNE;
    }
    
    public int getEnergie()
    {
        return this.santeBorne;
    }
    
    public void setEnergie(int s)
    {
        this.santeBorne = s;
    }
    
    public void rendreEnergie(int santeRendue, Robot r)
    {
        r.reparer(santeRendue);
        this.santeBorne -= santeRendue;
    }
    
}
