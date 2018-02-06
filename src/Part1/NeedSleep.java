/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class NeedSleep implements State {
	
	Student student; 
	
	NeedSleep(Student student){
		this.student=student;
	}
	
	@Override
	public void coffeWork() {
		System.out.println("You are gonna Chronic Ilness!");
		student.setState(student.getSick());
	}

	@Override
	public void sleep() {
		System.out.println("You are sleeping!");
		student.setState(student.getReady());		
	}

	@Override
	public void outTillLate() {
		System.out.println("You already out till night!");
	}

	@Override
	public void buyGameTool() {
		System.out.println("You need to sleep not buy some game stuff!");
		
	}

	@Override
	public void cheating() {
		System.out.println("How the sick student success cheating !");
		
	}

	@Override
	public void exercise() {
		System.out.println("You need to sleep no exercise!");	
	}

	@Override
	public void hardWork() {
		System.out.println("You need to sleep no working!");
		
	}

}


