/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Ready implements State {
	
	Student student; 
	
	Ready(Student student){
		this.student=student;
	}
	
	@Override
	public void coffeWork() {
		System.out.println("You are not drink coffe!");
	}

	@Override
	public void sleep() {
		System.out.println("You are not sleep!");
	}

	@Override
	public void outTillLate() {
		System.out.println("You should sleep!");
		student.setState(student.getNeedSleep());
	}

	@Override
	public void buyGameTool() {
		System.out.println("You will be wasted!");
		student.setState(student.getWasted());
	}

	@Override
	public void cheating() {
		System.out.println("You will be punished and wasted!");
		student.setState(student.getWasted());
	}

	@Override
	public void exercise() {
		System.out.println("Keep exercise you will be FÝT!");
		student.setState(student.getFit());
	}

	@Override
	public void hardWork() {
		System.out.println("Keep working you will be GRADUTE !");
		student.setState(student.getGraduate());
	}

}
