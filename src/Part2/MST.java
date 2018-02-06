/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MST implements java.io.Serializable{
	private PriorityQueue edges;
	private int vCount;
	private Graph mst;
	private boolean[] marked;
	private List<Integer> par;
	
	public MST(Graph g){
	    mst = new Graph(g.getvCount());
        marked = new boolean[g.getvCount()];
    	edges = new PriorityQueue();
    	par = new ArrayList<Integer>();
    	for (int i = 0; i < g.getvCount(); i++) {
    		Iterator it = g.neighbours(i).iterator();
    		while (it.hasNext()) {
    			edges.add(it.next());	
    		}
    	}
    	Iterator it = edges.iterator();
    	int i=0;
    	while (it.hasNext()) {
	    	String str = it.next().toString();
	    	str= str.substring(str.indexOf('-')+1,str.indexOf(' '));
	    	par.add(g.findStart(str));
	    }
    	
	}
	
	public Graph minimumSpannigTree() {
    	Edge e = (Edge) edges.remove();
    	mst.addEdge(e);
    	int start= mst.findStart(e.getStartPoint());
    	marked[start] = true;
    	int i=0;
    	while (!edges.isEmpty()) {
    		Edge temp = (Edge) edges.remove();
    		int endP= par.get(i);
    		if(endP!=-1){
	    		if (!marked[endP]) {
	    			if (!mst.hasEdge(temp)) {
	    				mst.addEdge(temp);
	    				marked[endP] = true;
	    			}
	    		}
    		}else{
    			mst.addEdge(temp);
    		}	
    		i++;
    	}
    	return mst;
    }
   
}
