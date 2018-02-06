/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Wasted implements State {
	
	Student student; 
	
	Wasted(Student student){
		this.student=student;
	}
	
	@Override
	public void coffeWork() {
		System.out.println("Cofee is not save WASTED!");
	}

	@Override
	public void sleep() {
		System.out.println("Bad dream WASTED!");
		
	}

	@Override
	public void outTillLate() {
		System.out.println("WASTED man not out !");
	}

	@Override
	public void buyGameTool() {
		System.out.println("NO money WASTED!");
		
	}

	@Override
	public void cheating() {
		System.out.println("Yo success already WASTED!");
		
	}

	@Override
	public void exercise() {
		System.out.println("Wasted no exrcise!");	
	}

	@Override
	public void hardWork() {
		System.out.println("Not try LOSER!");
		
	}

}
