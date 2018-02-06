/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Part1Test {

	public static void main(String[] args) {
		
		Student student = new Student();	
		System.out.println("Student is good one ");
		
		student.exercise();
		student.hardWork();
		System.out.println("\n");
		
		System.out.println("Student is bad one ");
		student.setState(student.getReady());
		student.cheating();
		student.buyGameTool();
		System.out.println("\n");
		
		System.out.println("Student is confused one ");
		student.setState(student.getReady());
		student.outTillLate();
		student.sleep();
		student.outTillLate();
		student.coffeWork();
		
	}

}
