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
public class BorneEnergie extends Bonus {
    
    private static final int ENERGIEINITIALEBORNE = 100;
    private int energieBorne;
    
    public BorneEnergie(int x, int y)
    {
        super(x,y);
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
            this.energieBorne -= energieRendue - r.recharger(energieRendue);
    }
    
    @Override
    public void applyEffect(Robot r)
    {
        this.rendreEnergie(1,r);
    }
    
    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/borneenergie.png");
    }
}
