/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astarsearch;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Salik
 */
public class AStarSearch implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread thread = new Thread(new AStarSearch());
        thread.start();
        }    

    @Override
    public void run() {
        //Bør ændres til Lizard eller goonhilly
        String host = "localhost";
        //Bør ændres til noget andet.
        int port = 1099;
        
        System.out.println("Using registry on "+host+" port "+port);
        try{
            LocateRegistry.createRegistry(port);
            System.out.println("DataServer: Instatiation server objects...");
            SearchImpl s1 = new SearchImpl();
            System.out.println("DataServer: connectiong server objects to registry...");
            Registry registry = LocateRegistry.getRegistry(host, port);
            registry.rebind("Search", s1);
            System.out.println("DataServer: Waiting for client messages");
        } catch (Exception e) {
            System.out.println("=== DataServer Error ===");
            System.out.println("DataServer: Error description "+ e);
            System.out.println("---DataServer: Stacktrace ---");
            e.printStackTrace();
            System.out.println("=== DataServer Error (end) ===");  
        }
    }

}
