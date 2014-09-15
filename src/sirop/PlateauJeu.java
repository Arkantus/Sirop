/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package sirop;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author marc
 */
public class PlateauJeu {

    private int largeur; 
    private int hauteur;
    private ArrayList<Robot> robotList;
    private ArrayList<Obstacle> obstacleList;
    
    public PlateauJeu(int l, int h)
    {
        this.largeur = l;
        this.hauteur = h;
        this.robotList = new ArrayList();
        this.obstacleList = new ArrayList();       
    }
    
    public void addRobot(Robot r)
    {
        this.robotList.add(r);
    }
            
    public void addObstacle(Obstacle o)
    {
        this.obstacleList.add(o);
    }
    
    public void moveRobot(int direction, Robot r)
    {
       int deltax = 0;
       int deltay = 0;
        
        switch(direction){
            case 0: 
                deltax = 1;
                deltay = 0;
                break;
            case 1: 
                deltax = 1;
                deltay = 1;
                break;
            case 2: 
                deltax = 0;
                deltay = 1;
                break;
            case 3: 
                deltax = -1;
                deltay = 1;
                break;
            case 4: 
                deltax = -1;
                deltay = 0;
                break;
            case 5: 
                deltax = -1;
                deltay = -1;
                break;    
            case 6: 
                deltax = 0;
                deltay = -1;
                break;    
            case 7: 
                deltax = 1;
                deltay = -1;
                break;
        }
            
        Point2D newPos = new Point2D(r.getPos());
        newPos.translate(deltax, deltay);
        
        boolean isOnObstacle = false;
        for (Obstacle o : obstacleList) 
        {
            if(o.getPos().isEqual(newPos))
            {
                isOnObstacle = true;
                break;
            }
        }
        
        boolean hasEnoughEnergy = r.getEnergy()>0;
        
        if(!horsPlateau(newPos) && !isOnObstacle && hasEnoughEnergy)
            {
                r.depenserEnergie(1);
                r.setPos(newPos);
            }  
        else
            {
                System.out.println("Move failure");
            }
    }
    
    
    public void randomMoveRobots()
    {
        Random ranGenerator = new Random();
       for (Robot r : robotList) 
        {
            moveRobot(ranGenerator.nextInt(7), r);
        } 
        
    }
    
    public boolean horsPlateau(Point2D p)
    {
    return p.getX()<0 || p.getY() <0 && p.getX() >= largeur && p.getY() >= hauteur;
    }
    
    public void displayPlateau()
    {
        for (Obstacle o : obstacleList) 
        {
            System.out.println(o.toString());
        }
        for (Robot r : robotList) 
        {
            System.out.println(r.toString());
        }
    }
}
