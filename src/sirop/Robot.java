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
private int xPos;
private int yPos;
private int energy;
private int health; 
private static final int ROBOT_MAX_ENERGIE = 150;
private static final int ROBOT_MAX_SANTE = 200;
private static final int ROBOT_START_ENERGIE = 100;
private static final int ROBOT_START_SANTE = 100;
private static int robotCount = 0;


    public Robot()
    {
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
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
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
    
    public void moveRobot(int direction)
    {
       int deltax = 0;
       int deltay = 0;
        
        switch(direction){
            case 0: 
                break;
            case 1: 
                break;
            case 2: 
                break;
            case 3: 
                break;
            case 4: 
                break;
            case 5: 
                break;    
            case 6: 
                break;    
            case 7: 
                break;
        }
            
        this.depenserEnergie(1);
    }
    
    @Override
    public String toString()
    {
        return ("Nom : "+ this.nomRobot + " \n\tJe suis de type : " + this.getClass().toString().substring(12) + "\n\tEnergie : " + this.energy+ "\n\tSanté : " + this.health + "\n\tPosition : " + this.xPos + ","+this.yPos);
    }

    public void recharger(int energyRefill)
    {
        this.energy += energyRefill;
    }
    
    public void reparer(int healthRefill)
    {
        this.health += healthRefill;
    }
    
    private void depenserEnergie(int energySpent)
    {
        this.energy -= energySpent;
    }
    
    


}
