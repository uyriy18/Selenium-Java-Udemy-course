package Session14;

import java.util.stream.Stream;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream.of("Adc","soDm","Tijaa","fffdiv","Rae","Mlp").filter(x-> x.length() > 4).filter(y -> y.endsWith("a")).map(s -> s.toUpperCase()).
		forEach(s -> System.out.println(s));;
		
		Stream.of("A2dc","Ao3Dm","Tijaa","fffdiv","Rae","A1Mp").filter(x -> x.startsWith("A")).sorted().map(x -> x.toUpperCase()).
		forEach(s -> System.out.println(s));


	}

}
