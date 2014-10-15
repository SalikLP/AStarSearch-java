/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.util.Comparator;

/**
 * A small class that implements the comparator interface. It is used as
 * comparator for priority queue.
 *
 * @author Salik
 */
public class AStarNodeComparator implements Comparator<AStarNode> {

    /*
     Method that compares the f value of the AStarNodes(f = g + h)
     if 
     */
    @Override
    public int compare(AStarNode node1, AStarNode node2) {
        if (node1.getF() < node2.getF()) {
            return -1;
        } else if (node1.getF() > node2.getF()) {
            return 1;
        } else {
            return 0;
        }
    }

}
