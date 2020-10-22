class Homework8_9{
	public static void main(String[] args){
		/*(Game: play a tic-tac-toe game)
		In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O).
		When one player has placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won.
		A draw (no winner) occurs when all the cells on the grid have been filled with tokens and neither player has achieved a win.
		Create a program for playing tic-tac-toe. The program prompts two players to enter an X token and O token alternately.
		Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue).*/
		System.out.println("Start Program");

		Scanner input = new Scanner(System.in)
		int turns = 0;
		boolean keepGoing = true;

		char [][] board = {
			{ ' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3', ' '},
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{ ' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6', ' '},
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{ ' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9', ' '},
		};
		displayBoard(board);

		while(keepGoing && turns < 9){
			if(turns%2 == 1){
				getPlayerOnePlacement(board);
				displayBoard(board);
				turns++;
			}
			else{
				getPlayerTwoPlacement(board);
				displayBoard(board);
				turns++;
			}
		}
		System.out.println("End Program");
	}

	public static void displayBoard(char[][] board){
		for(int i = 0; i < board.length; i++){
			System.out.println("");
			for(int j = 0; j< 11; j++){
				System.out.print(board[i][j]);
			}
		}
		System.out.println("");

	}
	public static void getPlayerOnePlacement(char[][] board){
		board[0][1] = 'X';
	}
	public static void getPlayerTwoPlacement(char[][] board){
		board[2][1] = 'O';
	}
}
