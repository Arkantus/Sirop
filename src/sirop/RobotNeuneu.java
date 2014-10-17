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
    public RobotNeuneu(String Name, int x, int y, int nrj, int life)
    {
        super(Name,x,y,nrj,life);
    }

    @Override
    public ImageIcon getImage() {
        return new ImageIcon(new ImageIcon("res/img/robot13.png").getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_FAST));
    }
}
