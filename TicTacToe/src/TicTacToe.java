
public class TicTacToe {

	public static char[][] board = {
			{' ', ' ', 'A', ' ', 'B', ' ', 'C'},
			{'1', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'2', ' ', ' ', '|', ' ', '|', ' '},
			{' ', ' ', '—', '—', '—', '—', '—'},
			{'3', ' ', ' ', '|', ' ', '|', ' '}
			};
	public static void main(String[] args) {
		System.out.println("Tic-Tac-Toe");
		letsPlay();
	}
		
	public static void letsPlay() {
		boolean winner = false;		
		char currentPlayer = 'X';
		
		
	}
		
		for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        char currentPos = board[row][col];
        System.out.print(currentPos);
      }
      System.out.println();
		}
		char[] playableSpaces = {
			board[1][2],
			board[1][4],
			board[1][6],
			board[3][2],
			board[3][4],
			board[3][6],
			board[5][2],
			board[5][4],
			board[5][6]
		};
	}
}