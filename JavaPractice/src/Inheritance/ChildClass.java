package Inheritance;

import org.testng.annotations.Test;
public class ChildClass extends ParrentClass {

	
	
		
		public void testRun() 
		{
			partentMethod1();
			
		}
		
		@Test
		public void constructorCall()
		{
			ParameterizedConstructor par = new ParameterizedConstructor(5);
			System.out.println(par.increment());
			System.out.println(par.decrement());
			System.out.println(par.multiplyBy2());
			System.out.println(par.multiplyBy3());Схоже що 

		}


}
