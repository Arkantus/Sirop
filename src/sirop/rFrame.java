/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author IAZERTYUIOPI
 */
public class rFrame extends JFrame{
    
    private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if(e.getKeyChar()=='p'){
                    isPaused=true;
                }
                if(e.getKeyChar()=='g'){
                    isPaused=false;
                }
                
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                
            }
            return false;
        }
    }
    private JPanel pane;
    private JPanel[] cases;
    private final int lgr;
    private final int lrgr;
    private JMenuBar jMenuBar;
    private JMenu           jMenuFile;
    private JMenuItem       jFileNew;
    private JMenuItem       jFileOpen;
    private JMenuItem       jFileSave;
    private JMenuItem       jFileReset;
    private JMenuItem       jFileExit;
    private JMenu           jMenuAbout;
    private JMenuItem       jAboutInfo;
    private boolean isPaused;
    
    public rFrame(int longr, int largr) {
        
       super();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pane = new JPanel(new GridLayout(longr,largr,0,0));
       cases = new JPanel[longr*largr];
       for(int i=0;i<longr*largr;i++)
       {
           cases[i] = new JPanel(new BorderLayout());
           cases[i].setBackground(new Color(255,200,255));
       }
       this.add(pane);
       this.pack();
       this.setBounds(10, 10, longr*64, largr*74);
       lgr = longr;
       lrgr = largr;
       

       jMenuBar = new javax.swing.JMenuBar();
        jMenuBar.setMinimumSize(new java.awt.Dimension(320, 22));
        jMenuBar.setSize(new java.awt.Dimension(320, 20));
             
        isPaused = false;
        

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        
        
        // Menu
        jMenuFile = new JMenu("File");
        // Menu new
        jFileNew = new JMenuItem("New");
        // Menu open 
        jFileOpen = new JMenuItem("Open");
        // Menu save 
        jFileSave = new JMenuItem("Save");
        // Menu reset 
        jFileReset = new JMenuItem("Reset");
        // Menu exit
        jFileExit = new JMenuItem("Exit");        
              
        // Menu a propos
        jMenuAbout = new JMenu("About");
        jAboutInfo = new JMenuItem("Info");
        
        // Adding menu items to the menu
        jMenuFile.add(jFileNew);
        jMenuFile.add(jFileOpen);
        jMenuFile.add(jFileSave);
        jMenuFile.add(jFileReset);
        jMenuFile.add(jFileExit);
              
        jMenuAbout.add(jAboutInfo);
        
        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuAbout);
      
        // Ajout du menu a la JFrame
        setJMenuBar(jMenuBar);
    }

    public boolean getIsPaused() {
        return isPaused;
    }
    
    public void refreshGraphics() {
        
        pane.removeAll();
        for (int i =  0; i < lgr*lrgr; i++)
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

