/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author Salik
 */
public class AStarAlgorithm {
    /*
    Method that finds the shortest path between two nodes s and t.
    The return value is an ArrayList containing the nodes in the shortest path.
    */
    public List<Node> search(Graph graph, String s, String t) {
        Node source = graph.getNode(s);
        Node target = graph.getNode(t);
        HashMap<String, AStarNode> OPEN = new HashMap<>();
        HashMap<String, AStarNode> CLOSED = new HashMap<>();
        PriorityQueue<AStarNode> pQueue = new PriorityQueue(20, new AStarNodeComparator());
        AStarNode start = new AStarNode(source, 0, graph.getHeuristic(source, target));
        OPEN.put(source.getID(), start);
        pQueue.add(start);

        AStarNode goal = null;
        
        while (OPEN.size() > 0) {
            //Remove lowest rank item from OPEN and pQueue
            AStarNode x = pQueue.poll();
            OPEN.remove(x.getID());
            //Is lowest rank in OPEN/pQueue target
            if (x.getID().equals(target.getID())) {
                //found
                goal = x;
                break;
            } else {
                //Add current to CLOSED
                CLOSED.put(x.getID(), x);
                List<Node> neighbors = graph.getNeighbors(x.getID());
                //for neighbors of current
                for (Node neib : neighbors) {
                    
                    AStarNode visited = CLOSED.get(neib.getID());
                    if (visited == null) {
                        //Neighbor not in CLOSED
                        //cost = g(current) + movementcost(current , neighbor)
                        double g = x.getG() + graph.getCost(x.getNode(), neib);                        
                        AStarNode n = OPEN.get(neib.getID());
                        if (n == null) {
                            //Neighbor not in OPEN or CLOSED
                            n = new AStarNode(neib, g, graph.getHeuristic(neib, target));
                            n.setParent(x);
                            OPEN.put(neib.getID(), n);
                            pQueue.add(n);
                        } else if (g < n.getG()) {
                            //New path is better, change parent.
                            n.setParent(x);
                            n.setG(g);
                            n.setH(graph.getHeuristic(neib, target));
                        }
                    }
                }
            }
        }
        if (goal != null) {
            Stack<Node> stack = new Stack<>();            
            List<Node> nodeList = new ArrayList<>();            
            stack.push(goal.getNode());
            AStarNode parent = goal.getParent();
            
            while (parent != null) {
                //Walk through nodes from goal to source
                stack.push(parent.getNode());
                parent = parent.getParent();
            }
            while (stack.size() > 0) {
                Node n = stack.pop();                
                nodeList.add(n); 
            }
            return nodeList;
            
        }
        return null;
    }

}
