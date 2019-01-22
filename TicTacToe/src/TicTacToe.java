import java.util.Scanner;

public class TicTacToe {

	// Board is a global (to class) variable so that any function can touch it.
	public static char[][] board = {
			{' ', ' ', 'A', ' ', 'B', ' ', 'C'},
			{'1', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'2', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'3', ' ', ' ', '|', ' ', '|', ' '}
			};
	
	// movePlaceHolder is a global (to class) variable 
	public static char movePlaceHolder = '!';
	
	// movesLeft is a global (to class) variable to track when no moves are left (Cat's game).
	public static int movesLeft = 9;
	
//	Playable space reference:
//	board[1][2] is Row 1 Col A
//	board[1][4] is Row 1 Col B
//	board[1][6] is Row 1 Col C
//	board[3][2] is Row 2 Col A
//	board[3][4] is Row 2 Col B
//	board[3][6] is Row 2 Col C
//	board[5][2] is Row 3 Col A
//	board[5][4] is Row 3 Col B
//	board[5][6] is Row 3 Col C
	
	// Main method shows title and prints the initial blank board.
	public static void main(String[] args) {
		System.out.println("Tic-Tac-Toe");
		printBoard();
		letsPlay();
	}
	
	// Method which calls helper method for main game play, then checks for winner, and switches turn if no winner.
	public static void letsPlay() {
		boolean winner = false;		
		char currentPlayer = 'X';
		Scanner reader = new Scanner(System.in);
		while (!(winner)) {
			getPlayerMove(currentPlayer, reader); // Finally determined I had to declare the Scanner out here and pass it. If closed within getPlayerMove() it won't re-open on next turn for some reason.
			printBoard();
			movesLeft = movesLeft -1;
			winner = checkForWin(currentPlayer);			
			if (currentPlayer == ('X')) {
				currentPlayer = 'O';
			} else {
				currentPlayer = 'X';
			}		
		}
		reader.close();
		System.out.println("Game over.");
	}
	
	// Obtain player move choice, validate it, and update the play board.
	public static void getPlayerMove(char currentPlayer, Scanner reader) {		
		String chosenRow = ""; // Declares String variable for Row to be chosen by currentPlayer.
		String chosenCol = ""; // Declares String variable for Column to be chosen by currentPlayer.
		boolean validMove = false; // Declares boolean variable for move validation loop, initialized as false.
		boolean legalMove = false; // Declares boolean variable for move legality loop, initialized as false.
		while (!(legalMove)) { // Repeat move entry until legalMove is made true by isMoveLegal(), after inner loop validates.
			System.out.println("Please choose a row and column to place " + currentPlayer);
			System.out.print("Row (1, 2 or 3): ");
			chosenRow = reader.nextLine();
			System.out.print("Column (A, B or C): ");
			chosenCol = reader.nextLine();
			validMove = isMoveValid(chosenRow, chosenCol);
			while (!(validMove)) { // Repeat move entry until validMove is made true by isMoveValid().
				System.out.println("!!! Not a valid entry. Please choose a Row and column to place " + currentPlayer);
				System.out.print("Row (1, 2 or 3): ");
				chosenRow = reader.nextLine();
				System.out.print("Column (A, B or C): ");
				chosenCol = reader.nextLine();
				validMove = isMoveValid(chosenRow, chosenCol);
			}
			legalMove = isMoveLegal();						
		}
		updateBoard(chosenRow, chosenCol, currentPlayer);
	}
	
	// Prints the current play board.
	public static void printBoard() {
		for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        char currentPos = board[row][col];
        System.out.print(currentPos);
      }
      System.out.println();
		}
	}
	
	// Validates the entry of row and column. If invalid, inner loop in getPlayerMove() repeats until valid.
	public static boolean isMoveValid(String chosenRow, String chosenCol) {
		boolean isValid = false;
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[1][2];
		} else if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[1][4];
		} else if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[1][6];
		} else if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[3][2];
		} else if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[3][4];
		} else if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[3][6];
		} else if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[5][2];
		} else if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[5][4];
		} else if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[5][6];
		} else {
			isValid = false;
		}
		return isValid;
	}
	
	// Verifies if the move is legal (space has not been played). Returns to outer loop in getPlayerMove().
	public static boolean isMoveLegal() {
		boolean isLegal = true;
		if ((movePlaceHolder == 'X') || (movePlaceHolder == 'O')) {
			isLegal = false;
			System.out.println("!!! That space has already been played. Choose again.");
		}
		return isLegal;
	}
	
	// This method only runs once the move has been verified as both valid and legal. Updates the board with new move.
	public static void updateBoard(String chosenRow, String chosenCol, char currentPlayer) {
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("a"))) {
			board[1][2] = currentPlayer;
		}
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("b"))) {
			board[1][4] = currentPlayer;
		}
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("c"))) {
			board[1][6] = currentPlayer;
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("a"))) {
			board[3][2] = currentPlayer;
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("b"))) {
			board[3][4] = currentPlayer;
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("c"))) {
			board[3][6] = currentPlayer;
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("a"))) {
			board[5][2] = currentPlayer;
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("b"))) {
			board[5][4] = currentPlayer;
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("c"))) {
			board[5][6] = currentPlayer;
		}
	}
	
	// Checks for win condition or full board (Cat's game)
	public static boolean checkForWin(char currentPlayer) {
		boolean didSomeoneWin = false;
		// Horizontal (row) wins
		if (((board[1][2] == currentPlayer) && (board[1][4]  == currentPlayer) && (board[1][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Row 1!");
			didSomeoneWin = true;
		}
		if (((board[3][2] == currentPlayer) && (board[3][4]  == currentPlayer) && (board[3][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Row 2!");
			didSomeoneWin = true;
		}
		if (((board[5][2] == currentPlayer) && (board[5][4]  == currentPlayer) && (board[5][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Row 3!");
			didSomeoneWin = true;
		}
		// Vertical (column) wins
		if (((board[1][2] == currentPlayer) && (board[3][2]  == currentPlayer) && (board[5][2]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Column A!");
			didSomeoneWin = true;
		}
		if (((board[1][4] == currentPlayer) && (board[3][4]  == currentPlayer) && (board[5][4]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Column B!");
			didSomeoneWin = true;
		}
		if (((board[1][6] == currentPlayer) && (board[3][6]  == currentPlayer) && (board[5][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Column C!");
			didSomeoneWin = true;
		}
		// Diagonal wins
		if (((board[1][2] == currentPlayer) && (board[3][4]  == currentPlayer) && (board[5][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won diagonally!");
			didSomeoneWin = true;
		}
		if (((board[5][2] == currentPlayer) && (board[3][4]  == currentPlayer) && (board[1][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won diagonally!");
			didSomeoneWin = true;
		}
		// Cat's game check. If someone has already won it's skipped. If not, and if no moves are left, Cat wins.
		while (!(didSomeoneWin)) {
			if (movesLeft == 0) {
				didSomeoneWin = true;
				System.out.println("No moves left! This round goes to the Cat!");
			} else {
				break;
			}
		}
		return didSomeoneWin;
	}
}