/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author IAZERTYUIOPI
 */
public class rFrame extends JFrame{

    private JPanel pane;
    private JLabel[] labels;
    
    public rFrame(int longr, int largr) {
        
       super();
       this.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
       pane = new JPanel(new GridLayout(longr,largr,0,0));
       labels = new JLabel[longr*largr];
       this.add(pane);
       this.pack();
       this.setBounds(10, 10, longr*32, largr*32);
       
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
     * @return the labels
     */
    public JLabel[] getLabels() {
        return labels;
    }

    /**
     * @param labels the labels to set
     */
    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }


}

