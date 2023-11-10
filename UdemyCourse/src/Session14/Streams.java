package Session14;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList();
		names.add("Abc");
		names.add("Bccc");
		names.add("CCc");
		names.add("Dsa");
		names.add("AAA");
		names.add("oppp");
		
		System.out.println(names.stream().filter(x -> x.startsWith("A")).count());
		/*
		 * int count = 0; for(String name:names) { String n = name;
		 * if(n.startsWith("A")) { count++; }
		 * 
		 * } System.out.println(count);
		 */
		long c = Stream.of("Adc","Com","Tij","Fiv","Rae","Mlp").filter(x->
		{
			return x.startsWith("A");
		}).count();
		names.stream().filter(x -> x.length() > 3).forEach(s -> System.out.println(s));
		names.stream().filter(x -> x.length() > 3).limit(1).forEach(s -> System.out.println(s));
		
				


	}

}
