/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.util.Objects;

/**
 *This is a small class representing an edge in a graph
 * @author Salik
 */
public class Edge {
    private String name;
    private String from;
    private double cost;
    private String to;
    /*
    Constructor with that sets the initial parameters incl. cost
    */
    public Edge(String from, String to, String name, double cost){
        this.from = from;
        this.to = to;
        this.name = name;
        this.cost = cost;
    }
    /*
    Constructor without cost(used to remove an edge from the graph)
    */
    public Edge(String from, String to) {
        this.from = from;
        this.to = to;
    }
    /*
    Returns a string with the ID on the from-node
    */
    public String getFrom(){
        return from;
    }
    /*
    Returns a string with the ID on the to-node
    */
    public String getTo(){
        return to;
    }
    /*
    Returns a double with the cost of the edge.
    */
    public double getCost(){
        return cost;
    }
    /*
    Set a new cost value
    */
    public void setCost(double cost){
        this.cost = cost;
    }
    /*
    Returns a string with the name
    */
    public String getName(){
        return name;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.from);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.to);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        return true;
    }
    
}
