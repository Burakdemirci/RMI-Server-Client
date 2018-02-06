/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JTextArea;
 
public class Server implements ServerInterface {
    private MST minSpanTree;
	private IMatrix iMatrix;
    private final Lock _mutex = new ReentrantLock(true);
    private String myStr="";
    private JTextArea textArea;
    public Server() throws RemoteException {
   	
    }
    
    
    public synchronized String sentGraph(Graph g,String command) throws RemoteException {
    	_mutex.lock();
    	long startTime = System.currentTimeMillis();
    	Calendar cal = Calendar.getInstance();
    	myStr= command+" is call Time: "+cal.get(Calendar.HOUR_OF_DAY)+":"
				 +cal.get(Calendar.MINUTE)+":"
				 +cal.get(Calendar.SECOND)+"."+
				 cal.get(Calendar.MILLISECOND);
		System.out.print(myStr);
		
    	String str="";
    	if(command.compareTo("MST")==0){
    		minSpanTree = new MST(g);
    		str=minSpanTree.minimumSpannigTree().toString();
    		minSpanTree=null;
    	}
    	if(command.compareTo("IMatrix")==0){
    		iMatrix = new IMatrix(g);
    		str=iMatrix.getIMatrix();
    		iMatrix=null;
    	}
    
    	long elapsedTime = System.currentTimeMillis() - startTime;
    	myStr += " Elapsed time: "+elapsedTime+" milisecond\n";
    	System.out.print(myStr+"\n");
    	getText();
    	_mutex.unlock();
    	return str;
    }
    public void getText(){
    	textArea.append(myStr);
    	myStr="";
    }
   
    public static void main(String args[]) throws Exception {
    	
        System.out.println(" Server started ");
        Server server = new Server();
 
        try { 
        	
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(server,0);
            Registry registry;
            try { // Registry creation exception try - catch  
            	
            	registry = LocateRegistry.createRegistry(1099);

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	registry = LocateRegistry.getRegistry();
            }
            registry.rebind("Server", stub);
        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }


	public void startServer(JTextArea textArea) {
		try { 
			this.textArea=textArea;
			textArea.append("Server Start:\n");
        	Server server = this;
            ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(server,0);
            Registry registry;
            try { // Registry creation exception try - catch  
            	
            	registry = LocateRegistry.createRegistry(1099);

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	registry = LocateRegistry.getRegistry();
            }
            registry.rebind("Server", stub);
        } catch (RemoteException e) {
        	e.printStackTrace();
        }
	}


}

