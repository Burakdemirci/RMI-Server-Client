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

public class IMatrix {
	
	private PriorityQueue edges;
	private int count=0;
	private Graph mst;
	private List<String> city;
	private List<List<Integer>> matrix;
	
	public IMatrix(Graph g){
		mst = new Graph(g.getvCount());
    	edges = new PriorityQueue();
    	city = new ArrayList();
    	matrix =new ArrayList<>();
    	for (int i = 0; i < g.getvCount(); i++) {
    		Iterator it = g.neighbours(i).iterator();
    		while (it.hasNext()) {
    			edges.add(it.next());
    			count++;
    		}
    	}
	}
	
	public String getIMatrix(){
		String iMatrix="";
		Iterator it = edges.iterator();
    	while (it.hasNext()) {
	    	Edge e = (Edge) it.next();
	    	creteCityM(e.getStartPoint(),e.getEndPoint());
	    }
    	
    	for(int i=0; i<city.size(); i++)
    	{
    		matrix.add(new ArrayList());
    		Iterator itr = edges.iterator();
        	while (itr.hasNext()) {
    	    	Edge e = (Edge) itr.next();
    	    	if(city.get(i).compareTo(e.getStartPoint())==0 || city.get(i).compareTo(e.getEndPoint())==0)
    	    	{
    	    		iMatrix +="1 ";
    	    		matrix.get(i).add(1);
    	    	}
    	    	else{
    	    		matrix.get(i).add(0);
    	    		iMatrix +="0 ";
    	    	}	
    	    }
        	iMatrix +="\n";
    	}	
		return iMatrix;
	}
	
	private void creteCityM(String start, String end){
		boolean s=true,e=true;
		if(city.size()>0){
			
			for(int i=0; i<city.size(); i++){
				if(start.compareTo(city.get(i))==0){
					s=false;
				}
				if(end.compareTo(city.get(i))==0){
					e=false;
				}
				if(!e && !s)
					break;
			}
			
			if(s)
				city.add(start);
			if(e)
				city.add(end);
			
		}else{
			city.add(start);
			city.add(end);
		}
	}
}
