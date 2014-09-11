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
public class BorneEnergie extends Bonus{
    
    private static final int ENERGIEINITIALEBORNE = 100;
    private int energieBorne;
    
    public BorneEnergie(int _x, int _y)
    {
        super(_x,_y);
        this.energieBorne = ENERGIEINITIALEBORNE;
    }
    
    public int getEnergie()
    {
        return this.energieBorne;
    }
    
    public void setEnergie(int e)
    {
        this.energieBorne = e;
    }
    
    public void rendreEnergie(int energieRendue, Robot r)
    {
        r.recharger(energieRendue);
        this.energieBorne -= energieRendue;
    }
    
}
