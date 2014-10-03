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
public class RobotNeuneu extends Robot {

public RobotNeuneu(int x, int y)
    {
        super(x,y);
    }
public RobotNeuneu()
    {
        super();
    }

    @Override
    public ImageIcon getImage() {
        return new ImageIcon("res/robotneuneu.png");
    }
}
