/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;


import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph implements java.io.Serializable{

    private int vCount,count=0;
    private PriorityQueue[] adj;

    public int getvCount() {
    	return vCount;
    }

    public Graph(int vCount) {
		this.vCount = vCount;
		adj = new PriorityQueue[vCount];
		
		for (int i = 0; i < vCount; i++)
			adj[i] = new PriorityQueue();
    }

    public void addEdge(String city1, String city2, int distance) {
    	int i=-1;
    	if(city1.compareTo(city2)!=0){
	    	i= findStart(city1);
	    	if(i != -1)
	    		adj[i].add(new Edge(city1, city2, distance));
	    	else{
	    		if(count<vCount){
	    			adj[count].add(new Edge(city1, city2, distance));
	    			count++;
	    		}else{
	    			System.out.println("Stack is full your edge is not add");
	    		}
	    	}
    	}else{
    		System.out.println("NOT ADDED "+city1+"-"+city2+"["+distance+"] => They are same city ! ");
    	}
    }

    public void addEdge(Edge e) {
    	int i = findStart(e.getStartPoint());
    	if(i!= -1)
    		adj[i].add(e);
    	else{
    		if(count<vCount){
    			adj[count].add(e);
    			count++;
    		}else{
    			System.out.println("Stack is full your edge is not add");
    		}
    	}
    }
    
    public int findStart(String City){
    	int j=-1;
    	String str="";
    	for(int i=0; i<vCount; i++){
    		if(adj[i].peek()!=null)
	    		str=adj[i].peek().toString();
	    		if(str.length()!=0){
	    			str = str.substring(0,str.indexOf('-'));
	    			if(City.compareTo(str)==0){
	    				j=i;
	    				break;
	    			}
	    			str="";
	    		}else{
	    			break;
	    		}
    	}
    	return j;
    }
   
    
    public void removeEdge(String city1, String city2) {
    	int i= findStart(city1);
		Iterator it = adj[i].iterator();
		
		Edge other = new Edge(city1, city2, 0);
		while (it.hasNext()) {
			if (it.next().equals(other)) {
				it.remove();
				return;
			}
		}
    }


    public boolean hasEdge(Edge e) {
    	int i= findStart(e.getStartPoint());
    	if(i==-1)
    		return false;
    	return adj[i].contains(e);	
    }


    public PriorityQueue neighbours(int vertex) {
    	return adj[vertex];
    }
    
    @Override
    public String toString(){
    	String str="";
    	for (int i = 0; i < count; i++) {
			
			PriorityQueue edges = neighbours(i);
			Iterator it = edges.iterator();
			//System.out.print(i + ": ");
			str += i + ": ";
			for (int j = 0; j < edges.size(); j++) {
				//System.out.print(it.next() + " ");
				str += it.next() + " ";
			}
			//System.out.println();
			str += "\n";
		}
    	return str;
    }

    public void printGraph() {
    	System.out.print(this.toString());
    }
    
    
}