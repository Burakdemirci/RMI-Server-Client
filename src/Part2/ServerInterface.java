/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
	
	public String sentGraph(Graph g,String command) throws RemoteException;
}
