/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part1;

public class Student {
	private State ready,wasted;
	private State graduate,fit;
	private State sick,needSleep;
	private State state;
	
	Student(){
		graduate = new Graduate(this); 
		fit = new Fit(this);
		sick = new Sick(this);
		needSleep =  new NeedSleep(this);
		wasted = new Wasted(this);
		ready = new Ready(this);
		state = ready;
	}
	
	/* State getter */
	
	public State getGraduate(){
		return graduate;
	}
	public State getFit(){
		return fit;
	}
	public State getSick(){
		return sick;
	}
	public State getNeedSleep(){
		return needSleep;
	}
	public State getReady(){
		return ready;
	}
	public State getWasted(){
		return wasted;
	}
	
	public void setState(State setS){
		this.state = setS;
	}
	
		
    /*-******** State Call ***********-*/
	
	public void coffeWork() {
		
		state.coffeWork();
	}

	public void sleep() {
		state.sleep();
	}

	public void outTillLate() {
		state.outTillLate();
	}

	public void buyGameTool() {
		state.buyGameTool();
	}

	public void cheating() {
		state.cheating();
	}

	public void exercise() {
		state.exercise();		
	}

	public void hardWork() {
		state.hardWork();
	}	
}
