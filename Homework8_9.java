import java.util.Scanner;

class Homework8_9{
	public static void main(String[] args){
		/*(Game: play a tic-tac-toe game)
		In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O).
		When one player has placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won.
		A draw (no winner) occurs when all the cells on the grid have been filled with tokens and neither player has achieved a win.
		Create a program for playing tic-tac-toe. The program prompts two players to enter an X token and O token alternately.
		Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue).*/
		System.out.println("Start Tic-Tac-Toe");

		Scanner input = new Scanner(System.in);

		char[][] board = makeBoard();
		boolean keepGoing = true;

		System.out.print("Hello player one! ");
		String playerOne = getName(input);
		System.out.print("Hello player two! ");
		String playerTwo = getName(input);
		while(keepGoing){
			board = makeBoard();
			displayBoard(board);
			keepGoing = playTicTacToe(board, input, playerOne, playerTwo);
		}
		System.out.println("End Program");
	}

	public static char[][] makeBoard(){
		char[][] board = {
			{ ' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3', ' '},
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{ ' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6', ' '},
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{ ' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9', ' '},
		};
		return board;
	}

	public static void displayBoard(char[][] board){
		for(int i = 0; i < board.length; i++){
			System.out.println("");
			for(int j = 0; j< 11; j++){
				System.out.print(board[i][j]);
			}
		}
		System.out.println("\n");

	}

	public static String getName(Scanner input){
		System.out.print("Enter your name: ");
		String name = input.next();
		return name;
	}

	public static boolean playTicTacToe(char[][] board, Scanner input, String playerOne, String playerTwo){
		boolean noWin = true;
		int turns = 0;
		while(turns < 9 && noWin){
			if(turns%2 == 0){
				getPlayerOnePlacement(board, input, playerOne);
				displayBoard(board);
				turns++;
			}
			else{
				getPlayerTwoPlacement(board, input, playerTwo);
				displayBoard(board);
				turns++;
			}
			if(turns >= 5){
				noWin = checkForWin(board, playerOne, playerTwo);
			}
		}
		if(noWin){
			System.out.println("Looks like no one won.");
		}
		boolean rematch = askForRematch(input);
		return rematch;
	}

	public static void getPlayerOnePlacement(char[][] board, Scanner input, String player){
		int choice = 0;
		boolean invalid = true;
		char piece = 'X';
		while(invalid){
			System.out.print(player + " please enter the square you would like to put an X in: ");
			choice = input.nextInt();
			invalid = checkValidInput(board, choice);
		}
		changeBoard(board, choice, piece);
	}

	public static void getPlayerTwoPlacement(char[][] board, Scanner input, String player){
		int choice = 0;
		boolean invalid = true;
		char piece = 'O';
		while(invalid){
			System.out.print(player + " please enter the square you would like to put an O in: ");
			choice = input.nextInt();
			invalid = checkValidInput(board, choice);
		}
		changeBoard(board, choice, piece);
	}

	public static boolean checkValidInput(char[][] board, int choice){
		switch(choice){
			case 1:
				if(board[0][1] == '1'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 2:
				if(board[0][5] == '2'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 3:
				if(board[0][9] == '3'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 4:
				if(board[2][1] == '4'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 5:
				if(board[2][5] == '5'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 6:
				if(board[2][9] == '6'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 7:
				if(board[4][1] == '7'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 8:
				if(board[4][5] == '8'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			case 9:
				if(board[4][9] == '9'){
					return false;
				}
				else{
					System.out.println("That spot is already occupied");
				}
				break;
			default:
				System.out.println("That's not a valid input, try again");
				return false;
		}
		return true;
	}

	public static void changeBoard(char[][] board, int choice, char piece){
		switch(choice){
			case 1:
				board[0][1] = piece;break;
			case 2:
				board[0][5] = piece;break;
			case 3:
				board[0][9] = piece;break;
			case 4:
				board[2][1] = piece;break;
			case 5:
				board[2][5] = piece;break;
			case 6:
				board[2][9] = piece;break;
			case 7:
				board[4][1] = piece;break;
			case 8:
				board[4][5] = piece;break;
			case 9:
				board[4][9] = piece;
		}
	}

	public static boolean askForRematch(Scanner input){
		System.out.print("Would you like a rematch?\ny for yes, and n for no: ");
		char answer = input.next().charAt(0);
		if(answer == 'y' || answer == 'Y'){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean checkForWin(char[][] board, String p1, String p2){
		String winner = "";
		int xOrO = 0;
		boolean winnerYes = false;

		char[][] winningConditions ={
			{board[0][1], board[0][5], board[0][9]},
			{board[2][1], board[2][5], board[2][9]},
			{board[4][1], board[4][5], board[4][9]},
			{board[0][1], board[2][1], board[4][1]},
			{board[0][5], board[2][5], board[4][5]},
			{board[0][9], board[2][9], board[4][9]},
			{board[0][1], board[2][5], board[4][9]},
			{board[0][9], board[2][5], board[4][1]}
		};

		for(int i = 0; i < winningConditions.length; i++){
			char one = winningConditions[i][0];
			char two = winningConditions[i][1];
			char three = winningConditions[i][2];
			if(one == 'X' && two == 'X' && three == 'X'){
				winnerYes = true;
				xOrO = 1;
				break;
			}
			else if(one == 'O' && two == 'O' && three =='O'){
				winnerYes = true;
				xOrO = 2;
				break;
			}
			else{
				winnerYes = false;
			}
		}

		if(xOrO == 1){
			winner = p1;
		}
		else if(xOrO == 2){
			winner = p2;
		}

		if(winnerYes){
			System.out.println(winner + " won the round!");
			return false;
		}
		return true;
	}
}
