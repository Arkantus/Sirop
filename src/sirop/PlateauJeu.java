/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package sirop;
import java.util.ArrayList;

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
    
    
}
