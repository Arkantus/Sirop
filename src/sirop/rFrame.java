/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author IAZERTYUIOPI
 */
public class rFrame extends JFrame{

    private JPanel pane;
    private JPanel[] cases;
    
    public rFrame(int longr, int largr) {
        
       super();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pane = new JPanel(new GridLayout(longr,largr,0,0));
       cases = new JPanel[longr*largr];
       for(int i=0;i<longr*largr;i++)
       {
           cases[i] = new JPanel(new BorderLayout());

           cases[i].setBackground(new Color(255,79,70));
       }
       this.add(pane);
       this.pack();
       this.setBounds(10, 10, longr*64, largr*74);
       
    }

    public void refreshGraphics() {
        
        pane.removeAll();
        for (int i =  0; i < 100; i++)
        {
            pane.add(cases[i]);
        }
        this.repaint();
        this.setVisible(true);
    }
    
    /**
     * @return the pane
     */
    public JPanel getPane() {
        return pane;
    }
    /**
     * @param pane the pane to set
     */
    public void setPane(JPanel pane) {
        this.pane = pane;
    }

    /**
     * @return the cases
     */
    public JPanel[] getCases() {
        return cases;
    }

    /**
     * @param cases the cases to set
     */
    public void setCases(JPanel[] cases) {
        this.cases = cases;
    }

    public void addJPanel(JPanel j)
    {
        pane.add(j);
    }
}

