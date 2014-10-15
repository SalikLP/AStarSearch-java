/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.*;
import java.rmi.server.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Salik
 */
public class SearchImpl extends UnicastRemoteObject implements Search{
    Graph graph;    
    
    public SearchImpl() throws RemoteException{
        graph = new Graph();
        Node A = new Node("A", new Position(0, 0));
        Node B = new Node("B", new Position(4, 5));
        Node C = new Node("C", new Position(5, 5));
        Node D = new Node("D", new Position(10, 0));
        graph = new Graph();
        graph.addNodeToGraph(A);
        graph.addNodeToGraph(B);
        graph.addNodeToGraph(C);
        graph.addNodeToGraph(D);
        graph.addConnection("A", "B", "Linie ab", 6);
        graph.addConnection("A", "C", "Linie ac", 5);
        graph.addConnection("B", "D", "Linie bd", 40);
        graph.addConnection("C", "D", "Linie cd", 50);
    }
    
    @Override
    public List<Node> search(String source, String target) throws RemoteException {
        AStarAlgorithm AS = new AStarAlgorithm();
        List<Node> path = AS.search(graph, source, target);
        return path;        
    }

    @Override
    public String getEdge(Node n1, Node n2) throws RemoteException {
        return graph.getEdge(n1, n2).getName() ;
    }
    
}
