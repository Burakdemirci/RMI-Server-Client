/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Sick implements State {
	
	Student student; 
	
	Sick(Student student){
		this.student=student;
	}
	
	@Override
	public void coffeWork() {
		System.out.println("You are addicted already!");
	}

	@Override
	public void sleep() {
		System.out.println("You shoul listen the begining!");
		
	}

	@Override
	public void outTillLate() {
		System.out.println("You are SICK student not a night watcher!");
	}

	@Override
	public void buyGameTool() {
		System.out.println("You are sick not now buy some game stuff!");
		
	}

	@Override
	public void cheating() {
		System.out.println("How the sick student success cheating !");
		
	}

	@Override
	public void exercise() {
		System.out.println("You are sick no exercise!");	
	}

	@Override
	public void hardWork() {
		System.out.println("You are sick no working!");
		
	}

}

