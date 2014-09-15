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
       
            
        Point2D newPos = new Point2D(r.getPos(),direction);
        
        boolean hasEnoughEnergy = r.getEnergy()>0;
        
        if(!horsPlateau(newPos) && caseLibre(newPos) && hasEnoughEnergy)
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
        return ( (p.getX() < 0) || (p.getY() < 0) || (p.getX() >= largeur) || (p.getY() >= hauteur) );
    }
    
    public boolean caseLibre(Point2D p)
    {                
        for (Obstacle o : obstacleList) 
        {
            if(o.getPos().isEqual(p))
            {
                return false;
            }
        }
        
        for (Robot r : robotList) 
        {
            if(r.getPos().isEqual(p))
            {
                return false;
            }
        } 
        return true;   
    }
    
    public ArrayList<Point2D> casesLibresAround(Point2D p)
    {
        ArrayList<Point2D> pointList = new ArrayList();
        Point2D currentAdjPoint;
        
        for(int k=0; k<=7; k++)
        {
            currentAdjPoint = new Point2D(p, k);
            if(!horsPlateau(currentAdjPoint) && caseLibre(currentAdjPoint))
            {
                pointList.add(currentAdjPoint);
            }
            
        }
        
        return pointList;
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
