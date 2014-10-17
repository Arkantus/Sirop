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
public class RobotCombattant  extends Robot {

public RobotCombattant(int x, int y)
    {
        super(x,y);
    }    

public RobotCombattant()
    {
        super();
    }

    @Override
    public ImageIcon getImage() {
        return new ImageIcon(new ImageIcon("res/img/robot.png").getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_FAST));
    }
    
    public RobotCombattant(String Name, int x, int y, int nrj, int life)
    {
        super(Name,x,y,nrj,life);
    }


}