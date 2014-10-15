/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.io.Serializable;

/**
 * A small class representing a node in a graph.
 * The node has an ID and a position.
 * @author Salik
 */
public class Node implements Serializable{
    
    protected String id;
    protected Position position;
    /*
    Constructor to set the default values for the node
    */
    public Node(String ID, Position position){
        this.id = ID;
        this.position = position;
    }
    /*
    Method that returns the ID of the node
    */
    public String getID(){
        return id;
    }
    /*
    Method that returns the position of the node.
    */
    public Position getPosition(){
        return position;
    }
}
