class Homework8_18{
	public static void main(String[] args){
		/*(Shuffle rows)
		Write a method that shuffles the rows in a two-dimensional
		int array using the following header:
		public static void shuffle(int[][] m)
		Write a test program that shuffles the following matrix:
		int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};*/

		int[][] m = makeArray();
		System.out.println("Original order");
		displayArray(m);
		m = shuffle(m);
		System.out.println("New order");
		displayArray(m);
	}

	public static int[][] makeArray(){
		int[][] array ={{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
		return array;
	}

	public static void displayArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i][0] + " and " + array[i][1]);
		}
	}
	public static int[][] shuffle(int[][] m){
		int[] temp = new int [2];
		for(int turns = 0; turns < 10; turns++){
			int numberOne = (int)(Math.random()*100)%5;
			int numberTwo = (int)(Math.random()*100)%5;

			temp[0] = m[numberOne][0];
			temp[1] = m[numberOne][1];
			m[numberOne][0] = m[numberTwo][0];
			m[numberOne][1] = m[numberTwo][1];
			m[numberTwo][0] = temp[0];
			m[numberTwo][1] = temp[1];
		}
	return m;
	}
}
