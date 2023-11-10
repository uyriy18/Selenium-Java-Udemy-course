package Session14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> first = new ArrayList();
		first.add("Anton");
		first.add("Lobster");
		first.add("Lyla");
		first.add("Crazy");
		first.add("Bit");
		first.add("Shoyich");
		first.add("Malitious");
		first.add("Greg");
		first.add("Sem");
		
		ArrayList<String> newList = (ArrayList<String>) first.stream().filter(x -> x.startsWith("S")).sorted().map(x-> x.toUpperCase()).collect(Collectors.toList());
		
		List<Integer> values =Arrays.asList(1,2,3,4,5,6,2,8,3) ;
		values.stream().distinct().sorted().forEach(x -> System.out.println(x));
	}

}
