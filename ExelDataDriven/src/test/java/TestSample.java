import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
	public static void main(String[] args) throws IOException {
		DataDriven data = new DataDriven();
		ArrayList<String> array = data.getData("Add profile");
		for(String a : array) {
			System.out.println(a);
		}
	}

}
