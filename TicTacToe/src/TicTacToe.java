import java.util.Scanner;

public class TicTacToe {

	public static char[][] board = {
			{' ', ' ', 'A', ' ', 'B', ' ', 'C'},
			{'1', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'2', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'3', ' ', ' ', '|', ' ', '|', ' '}
			};
	public static char movePlaceHolder = '!';
	/* For reference, these are the valid playable spaces:
			board[1][2] is Row 1 Col A
			board[1][4] is Row 1 Col B
			board[1][6] is Row 1 Col C
			board[3][2] is Row 2 Col A
			board[3][4] is Row 2 Col B
			board[3][6] is Row 2 Col C
			board[5][2] is Row 3 Col A
			board[5][4] is Row 3 Col B
			board[5][6] is Row 3 Col C
		*/
	public static void main(String[] args) {
		System.out.println("Tic-Tac-Toe");
		printBoard();
		letsPlay();
	}
		
	public static void letsPlay() {
		boolean winner = false;		
		char currentPlayer = 'X';
		while (!(winner)) {
			getPlayerMove(currentPlayer);
			printBoard();
			winner = checkForWin(currentPlayer);
			if (currentPlayer == ('X')) {
				currentPlayer = 'O';
			} else {
				currentPlayer = 'X';
			}			
		}
		System.out.println("Game over.");
	}
	
	public static void getPlayerMove(char currentPlayer) {
		Scanner reader = new Scanner(System.in);
		String chosenRow = "";
		String chosenCol = "";
		boolean validMove = false;
		boolean legalMove = false;
		while (!(legalMove)) {
			while (!(validMove)) {
				System.out.println("Please choose a row and column to place " + currentPlayer);
				System.out.print("Row (1, 2 or 3): ");
				chosenRow = reader.next();
				System.out.print("Column (A, B or C): ");
				chosenCol = reader.next();
				validMove = isMoveValid(chosenRow, chosenCol);				
			}
			legalMove = isMoveLegal();
		}
		updateBoard(chosenRow, chosenCol, currentPlayer);
		reader.close();
	}
	
	public static void printBoard() {
		for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        char currentPos = board[row][col];
        System.out.print(currentPos);
      }
      System.out.println();
		}
	}
	
	// Validates the entry of row and column.
	public static boolean isMoveValid(String chosenRow, String chosenCol) {
		boolean isValid = false;
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[1][2];
		}
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[1][4];
		}
		if ((chosenRow.equals("1")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[1][6];
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[3][2];
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[3][4];
		}
		if ((chosenRow.equals("2")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[3][6];
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("a"))) {
			isValid = true;
			movePlaceHolder = board[5][2];
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("b"))) {
			isValid = true;
			movePlaceHolder = board[5][4];
		}
		if ((chosenRow.equals("3")) && (chosenCol.equalsIgnoreCase("c"))) {
			isValid = true;
			movePlaceHolder = board[5][6];
		} else {
			isValid = false;
			System.out.println("Invalid selection. Please enter Row 1, 2, or 3, then Column A, B, or C.");
		}
		return isValid;
	}
	
	public static boolean isMoveLegal() {
		boolean isLegal = true;
		if ((movePlaceHolder == 'X') || (movePlaceHolder == 'O')) {
			isLegal = false;
			System.out.println("That space has already been played. Choose again.");
		}
		return isLegal;
	}
	
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
			System.out.println("Player " + currentPlayer + " won in Row 1!");
			didSomeoneWin = true;
		}
		if (((board[5][2] == currentPlayer) && (board[3][4]  == currentPlayer) && (board[1][6]) == currentPlayer)) {
			System.out.println("Player " + currentPlayer + " won in Row 2!");
			didSomeoneWin = true;
		}	
		return didSomeoneWin;
	}
}