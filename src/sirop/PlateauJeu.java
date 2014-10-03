/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package sirop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    

   
        public void moveMovable(int direction, Movable m)
    {
       
        Point2D newPos = new Point2D(m.getPos(),direction);
        
        
        if(!horsPlateau(newPos) && caseLibre(newPos))
            {
                m.setPos(newPos);
            }  
        else
            {
                System.out.println("Move failure : collision");
            }
    }
    
    public void randomMoveRobots()
    {
        Random ranGenerator = new Random();
       for (Robot r : robotList) 
        {
            HashMap caseslibresautourdurobotr = casesLibresAround(r.getPos());
            int rand;
            do {rand = ranGenerator.nextInt(7);}
            while(!caseslibresautourdurobotr.containsValue(rand));
            moveMovable(rand, r);
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
    
    public HashMap casesLibresAround(Point2D p)
    {
        HashMap<Point2D,Integer> pointMap = new HashMap<>();
        Point2D currentAdjPoint;
        
        for(int k=0; k<=7; k++)
        {
            currentAdjPoint = new Point2D(p, k);
            if(!horsPlateau(currentAdjPoint) && caseLibre(currentAdjPoint))
            {
                pointMap.put(currentAdjPoint, k);
            }
            
        }
        
        return pointMap;
    }
    
    public ArrayList obstaclesAutour(Point2D p)
    {
        ArrayList<Obstacle> oList = new ArrayList<>();
        Point2D currentAdjPoint;
        
        for(int k=0; k<=7; k++)
        {
        currentAdjPoint = new Point2D(p, k);
        
        for (Obstacle o : obstacleList) 
        {
            if(o.getPos().isEqual(currentAdjPoint))
            {
                oList.add(o);
            }
        }
        
        }
        return oList;
    }
    
    public void applyBonuses()
    {
       for (Robot r : robotList) 
        {
            ArrayList<Obstacle> oList = obstaclesAutour(r.getPos());
            if(oList.size()>0)
            {
                for(Obstacle o : oList)
                {
                    o.applyEffect(r);
                }
            }
        } 
    }
    
    public void displayPlateau(JLabel[] labels)
    {
        int x;
        int y;
        
        for (Obstacle o : obstacleList) 
        {
            x = o.getPos().getX();
            y = o.getPos().getY();
            labels[25*y+(x)] = new JLabel(o.getImage());
        }
        for (Robot r : robotList) 
        {
            x = r.getPos().getX();
            y = r.getPos().getY();
            labels[25*y+(x)] = new JLabel(r.getImage());
        }
    }
    
    public void displayToString()
    {
        char[][] plat = new char[this.hauteur][this.largeur];
        for(int i = 0 ; i < this.hauteur ; i ++) for(int  j = 0 ; j < this.largeur ; j ++) plat[i][j] = ' ';
        for (Obstacle o : obstacleList) 
        {
            plat[o.getPos().getX()][o.getPos().getY()] = 'o';
        }
        for (Robot r : robotList) 
        {
            plat[r.getPos().getX()][r.getPos().getY()] = 'r';
        }
        String value;
        for(int i = 0 ; i < this.hauteur ; i ++)
        {
            for(int  j = 0 ; j < this.largeur ; j ++)
            {
                System.out.print(plat[i][j]);
            }
            System.out.println();
        }
    }
    
}
