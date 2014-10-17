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
                    for(int i=0;i<lgr*lrgr;i++)
                        {
                            cases[i].setBackground(new Color(255,0,0));
                        }
                    isPaused=true;
                }
                if(e.getKeyChar()=='g'){
                    for(int i=0;i<lgr*lrgr;i++)
                        {
                            cases[i].setBackground(new Color(255,200,255));
                        }
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
    private JMenuItem       jFileOpen;
    private JMenuItem       jFileSave;
    private JMenuItem       jFileReset;
    private JMenuItem       initMenu;
    private JMenuItem       jFileNew;

    private boolean isPaused;
    private PlateauJeu plat;
    
    public rFrame(int longr, int largr, PlateauJeu p) {
        
       super();
       plat = p;
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

        jFileNew = new JMenuItem("New"){
            public String toString() {return "n";}
        };
         
        jFileOpen = new JMenuItem("Load"){
            public String toString() {return "o";}
        };
        // Menu save 
        jFileSave = new JMenuItem("Save"){
                        public String toString() {return "s";}
        };
        // Menu reset 
        jFileReset = new JMenuItem("Reset"){
                        public String toString() {return "t";}
        };
        
        jMenuFile.add(jFileOpen);
        jMenuFile.add(jFileSave);
        jMenuFile.add(jFileReset);
        jMenuFile.add(jFileNew);
                
        jMenuBar.add(jMenuFile);
      
        jFileOpen.addActionListener(new reactionMenu(this));
        jFileSave.addActionListener(new reactionMenu(this));
        jFileReset.addActionListener(new reactionMenu(this));
        jFileNew.addActionListener(new reactionMenu(this));
        
        
        // Ajout du menu a la JFrame
        setJMenuBar(jMenuBar);
    }

    public boolean getIsPaused() {
        return isPaused;
    }
    
    public PlateauJeu getPlat() {
        return plat;
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

