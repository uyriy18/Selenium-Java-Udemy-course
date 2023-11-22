package Inheritance;

public class ParameterizedConstructor extends SuperConstructor {
	private int i;
	
	ParameterizedConstructor(int i){
		super(i);
		this.i = i;
	}
	
	public int increment() {
		i++;
		return i;
		
	}
	public int decrement() {
		i--;
		return i;
	}
	

}
