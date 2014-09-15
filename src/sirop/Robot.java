/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirop;

/**
 *
 * @author marc
 */
public class Robot {
private String nomRobot;
private Point2D pos;
private int energy;
private int health; 
private static final int ROBOT_MAX_ENERGIE = 150;
private static final int ROBOT_MAX_SANTE = 200;
private static final int ROBOT_START_ENERGIE = 100;
private static final int ROBOT_START_SANTE = 100;
private static int robotCount = 0;


    public Robot()
    {
        pos = new Point2D(0,0);
        robotCount++;
        this.energy = Robot.ROBOT_START_ENERGIE;
        this.health = Robot.ROBOT_START_SANTE;
    }

    public Robot(int x, int y)
    {
        pos = new Point2D(x, y);
        robotCount++;
        this.energy = Robot.ROBOT_START_ENERGIE;
        this.health = Robot.ROBOT_START_SANTE;
    }
    
    /**
     * @return the nomRobot
     */
    public String getNomRobot() {
        return nomRobot;
    }

    /**
     * @param nomRobot the nomRobot to set
     */
    public void setNomRobot(String nomRobot) {
        this.nomRobot = nomRobot;
    }

    /**
     * @return the position
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * @param p the Point2D position to set
     */
    public void setPos(Point2D p) {
        this.pos = new Point2D(p);
    }
   
    /**
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    
    
    @Override
    public String toString()
    {
        return ("Nom : "+ this.nomRobot + " \n\tJe suis de type : " + this.getClass().toString().substring(12) + "\n\tEnergie : " + this.energy+ "\n\tSanté : " + this.health + "\n\tPosition : " + this.pos.toString());
    }

    public int recharger(int energyRefill)
    {
        int excessEnergie = 0;
        if(this.energy + energyRefill <= ROBOT_MAX_ENERGIE)
            {
                this.energy += energyRefill;
            }
        else{
                excessEnergie = this.energy + energyRefill - ROBOT_MAX_ENERGIE;
                this.energy = ROBOT_MAX_ENERGIE;
            }
        return excessEnergie;
    }
    
    public int reparer(int healthRefill)
    {
        int excessSante = 0;
        if(this.health + healthRefill <= ROBOT_MAX_SANTE)
            {
                this.health += healthRefill;
            }
        else{
                excessSante = this.health + healthRefill - ROBOT_MAX_SANTE;
                this.health = ROBOT_MAX_SANTE;
            }
        return excessSante;
    }
    
    public void depenserEnergie(int energySpent)
    {
        this.energy -= energySpent;
    }
    
    


}
