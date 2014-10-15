/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.rmi.*;
import java.util.List;

/**
 *
 * @author Salik
 */
public interface Search extends Remote {

    /**
     *
     * @param source The starting node
     * @param target The target node to find shortest path to.
     * @return a list containing the nodes in the shortest path.
     * @throws RemoteException
     */
    public List<Node> search(String source, String target) throws RemoteException;
    
    public String getEdge(Node n1, Node n2)throws RemoteException;
    
}
