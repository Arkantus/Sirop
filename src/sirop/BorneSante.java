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
    
    public BorneSante( int sante ,int x, int y)
    {
        super(x,y);
        this.santeBorne = sante;
    }
    
    public int getNiveau()
    {
        return this.santeBorne;
    }
    
    public void setNiveau(int s)
    {
        this.santeBorne = s;
    }
    
    @Override
    public void applyEffect(Robot r)
    {
        this.rendreNiveau(1,r);
    }
    
    public void rendreNiveau (int santeRendue, Robot r)
    {
        if(this.getNiveau()>0)
        {this.santeBorne -= santeRendue - r.reparer(santeRendue);}
        else{};
    }
    
    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/bornesante.png");
    }
}
