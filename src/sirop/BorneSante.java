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
public class BorneSante extends Bonus {
    
    private static final int SANTEINITIALEBORNE = 100;
    private int santeBorne;

    public BorneSante(int x, int y)
    {
        super(x,y);
        this.santeBorne = SANTEINITIALEBORNE;
    }
    
    public int getSante()
    {
        return this.santeBorne;
    }
    
    public void setEnergie(int s)
    {
        this.santeBorne = s;
    }
    
    @Override
    public void applyEffect(Robot r)
    {
        this.rendreSante(1,r);
    }
    
    public void rendreSante(int santeRendue, Robot r)
    {
        this.santeBorne -= santeRendue - r.reparer(santeRendue);
    }
    
    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/bornesante.png");
    }
}
