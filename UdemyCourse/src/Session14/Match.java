package Session14;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Match {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> first = new ArrayList();
		ArrayList<String> second = new ArrayList();
		first.add("Anton");
		first.add("Lobster");
		first.add("Lyla");
		first.add("Crazy");
		first.add("Bit");
		second.add("Shoyich");
		second.add("Malitious");
		second.add("Greg");
		second.add("Sem");
		
		Stream <String> merged = Stream.concat(first.stream(), second.stream()).sorted();
		if (merged.anyMatch(s -> s.equalsIgnoreCase("Sem"))) {
			System.out.println("True");
		}
			

	}

}
