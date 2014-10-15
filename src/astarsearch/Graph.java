/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 * This is a class representing a graph. 
 * The class has two Lists, one with nodes and one with edges connecting the nodes.
 * 
 * @author Salik
 */
public class Graph {
    
    protected List<Node> nodeList;
    protected List<Edge> edgeList;
    /*
    Constructor to initialize the fields
    */
    public Graph(){
        this.nodeList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }
    /*
    Method to add a connection between two nodes.
    It finds the nodes via the String ID and sets the cost to the double supplied as parameter.
    */
     public void addConnection(String firstID, String secondID, String name, double cost){
         Node node1 = getNode(firstID);
         Node node2 = getNode(secondID);
         if(node1 != null && node2 != null){             
             Edge edge1 = new Edge(firstID, secondID, name, cost);
             Edge edge2 = new Edge(secondID, firstID, name, cost);
             addEdgeToGraph(edge1);
             addEdgeToGraph(edge2);
         }
     }
     /*
     Method to remove a connection between two nodes.
     It finds the nodes via the String ID
     */
     public void removeConnection(String firstId, String secondId){
        Edge edge1 = new Edge(firstId, secondId);
        Edge edge2 = new Edge(secondId, firstId);
        removeEdge(edge1);
        removeEdge(edge2);
     }
    /*
     Method to get heuristic between two nodes.
     It calculates the euclidean distance.
     */ 
    public double getHeuristic(Node a, Node b){
        return Math.sqrt(((a.getPosition().getX() - b.getPosition().getX())*(a.getPosition().getX() - b.getPosition().getX()))
                + ((a.getPosition().getY() - b.getPosition().getY())*(a.getPosition().getY() - b.getPosition().getY())));
    }
    /*
    Method to get a node by String ID
    */
    public Node getNode(String ID){
        Node get = null;
        for(Node n: nodeList){
            if(n.getID().equals(ID)){
                get = n;                
            }            
        }
        return get;
    }
    /*
    Method to get the cost between two nodes.
    */
    public double getCost(Node n1, Node n2){
        double cost = -1;
        for(Edge e: edgeList){
            if(e.getFrom().equals(n1.getID()) && e.getTo().equals(n2.getID())){
                cost = e.getCost();
            }
        }
        return cost;
    }
    /*
    Method to ge a specific edge between two nodes
    */
    public Edge getEdge(Node n1, Node n2){
        Edge edge = null;
        for(Edge e: edgeList){
            if(e.getFrom().equals(n1.getID()) && e.getTo().equals(n2.getID())){
                edge = e;
            }
        }
        return edge;
    }
    /*
    Method to modify the cost of an edge
    */
    public void modifyEdgeCost(String Node1, String Node2, double cost){
        for(Edge e: edgeList){
            if(e.getFrom().equals(Node1) && e.getTo().equals(Node2)){
                e.setCost(cost);
            }
        }
    }
    /*
    Method to add a node to the graph
    */
    public void addNodeToGraph(Node node){
        nodeList.add(node);        
    }
    /*
    Method to ad an edge to the graph
    */
    private void addEdgeToGraph(Edge edge) {
        edgeList.add(edge);
    }
    /*
    Method to remove an edge from the graph
    */
    private void removeEdge(Edge edge) {
        if(edgeList.contains(edge)) edgeList.remove(edge);
    }
    /*
    Method to get the neighbors of a node
    The supplied string is used to find the correct node.
    The return value is an ArrayList containing all the neighbors
    */
    public List<Node> getNeighbors(String ID){
        List<Node> neighbors = new ArrayList<>();
        Node parent = getNode(ID);
        for(Edge e: edgeList){
            if(e.getFrom().equals(parent.getID())){
                neighbors.add(getNode(e.getTo()));
            }
        }
        return neighbors;
    }
}
