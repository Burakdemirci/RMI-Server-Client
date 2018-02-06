/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

public class Edge implements Comparable, java.io.Serializable{

    private String startPoint;

    private String endPoint;

    private int distance;


    public Edge(String startPoint, String endPoint, int distance) {

		this.startPoint = startPoint;
	
		this.endPoint = endPoint;
	
		this.distance = distance;

    }

    public String getStartPoint() {
    	return startPoint;
    }


    public String getEndPoint() {
    	return endPoint;
    }


    public int getDistance() {
    	return distance;
    }

    public boolean equals(Edge other) {

    	if (this.startPoint == other.startPoint) {
    		
    		if (this.endPoint == other.endPoint) {
    			return true;
    		}
    	}
		return false;
    }

    public int compareTo(Object o) {

		Edge other = (Edge) o;
	
		return Integer.compare(this.distance, other.distance);

    }

    @Override
    public String toString() {
    	return startPoint + "-" + endPoint + " [" + distance + "km]";
    }

}