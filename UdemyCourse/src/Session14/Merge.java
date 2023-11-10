package Session14;

import java.util.ArrayList;
import java.util.stream.Stream;
public class Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> first = new ArrayList();
		ArrayList<String> second = new ArrayList();
		first.add("1");
		first.add("3");
		first.add("5");
		first.add("7");
		first.add("9");
		second.add("2");
		second.add("4");
		second.add("6");
		second.add("8");
		
		Stream.concat(first.stream(), second.stream()).sorted().forEach(x -> System.out.println(x));
		





	}

}
