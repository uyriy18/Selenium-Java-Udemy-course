package Examples;

public class ArraysSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 2, 4, -2 }, 
				        { 3, 4, 1 }, 
				        { 1, 0, 9 } };
		
		int min = arr[0][0];
		int max = 0;
		int column = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(min > arr[i][j]) {
					min = arr[i][j];
					column = j;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			if(max < arr[i][column]) {
				max = arr[i][column];
			}
			
		}
		System.out.println(max);

	}

}
