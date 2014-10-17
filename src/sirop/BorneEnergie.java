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
    
    public BorneEnergie(int nrj, int x, int y)
    {
        super(x,y);
        this.energieBorne = nrj;
    }
    
    public int getNiveau()
    {
        return this.energieBorne;
    }
    
    public void setNiveau(int e)
    {
        this.energieBorne = e;
    }
    
    public void rendreNiveau(int energieRendue, Robot r)
    {
        if(this.getNiveau()>0)
        {this.energieBorne -= energieRendue - r.recharger(energieRendue);}
        else{};
    }
    
    @Override
    public void applyEffect(Robot r)
    {
        this.rendreNiveau(1,r);
    }
    
    @Override
    public ImageIcon getImage() {
        return new ImageIcon(new ImageIcon("res/img/energy.png").getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_FAST));
    }
}
