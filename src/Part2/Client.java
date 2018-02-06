/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client { 
	
    public static void main(String args[]) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        ServerInterface server = (ServerInterface) registry.lookup("Server"); 
        
        Graph g = new Graph(10);
		g.addEdge("�stanbul", "Erzurum",8);
		g.addEdge("Erzurum", "Ankara",5);
		g.addEdge("Ankara","�zmir",9);
		g.addEdge("�zmir","�stanbul",7);
		g.addEdge("�stanbul", "Ankara",1);
		g.addEdge("Konya", "Ankara",5);
		
		System.out.println("Graph Sent to Server MST Operation :");
		System.out.println(server.sentGraph(g,"MST")+"\n");
		
		System.out.println("Graph Sent to Server IMatrix Operation :");
		System.out.println(server.sentGraph(g,"IMatrix")+"\n");
        
       
    }
    
}