/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Fit implements State {
	
	Student student; 
	
	Fit(Student student){
		this.student=student;
	}
	
	@Override
	public void coffeWork() {
		System.out.println("Your health not safe !");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep tight!");
		
	}

	@Override
	public void outTillLate() {
		System.out.println("You are student not a night watcher!");
		
	}
	
	@Override
	public void buyGameTool() {
		System.out.println("Not now buy some game stuff!");
	}

	@Override
	public void cheating() {
		System.out.println("You will be punished !");
		
	}

	@Override
	public void exercise() {
		System.out.println("You already fit!");
	}

	@Override
	public void hardWork() {
		System.out.println("Keep working you will be graduate!");
		student.setState(student.getGraduate());
	}

}
