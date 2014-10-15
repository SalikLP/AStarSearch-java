/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

/**
 *
 * @author Salik
 */
public class AStarNode {
    
    private Node node;
    private AStarNode cameFrom;    
    //Distance from source via optimal path.
    private double g;
    //Heuristic estimate of distance from current node to target
    private double h;
    
    public AStarNode(Node n, double g, double h){
        this.node = n;
        this.g = g;
        this.h = h;
    }
    
    public double getF(){
        return g+h;
    }
    
    public double getG(){
        return g;
    }
    public void setG(double g){
        this.g = g;
    }
    
    public double getH(){
        return h;
    }
     public void setH(double h){
        this.h = h;
    }
    public void setParent(AStarNode cameFrom){
        this.cameFrom = cameFrom;
    }
    public String getID(){
        return node.getID();
    }
    public Node getNode(){
        return node;
    }
    public AStarNode getParent(){
        return cameFrom;                
    } 
    
    
}
