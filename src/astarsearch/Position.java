/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.io.Serializable;

/**
 * A very small class representing a position x,y
 * @author Salik
 */
public class Position implements Serializable{
    private double x;
    
    private double y;
    
    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }
    protected double getX(){
        return x;
    }
    protected double getY(){
        return y;
    }
    
   
    
}
