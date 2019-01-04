import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Introduction.
		System.out.println("Let's play Rock, Paper Scissors.");
		System.out.println("Press 0 for Rock, 1 for Paper, 2 for Scissors:");
		// Call method to get and display player choice.
		String PlayerChoice = getPlayerChoice();
		
		public static String getPlayerChoice() {
			Scanner reader = new Scanner(System.in);
			String playerRPS = reader.next();
			if (playerRPS.equalsIgnoreCase("rock")){
				System.out.println("You chose Rock.");
			}
			if (playerRPS.equalsIgnoreCase("paper")){
				System.out.println("You chose Paper.");
			}
			if (playerRPS.equalsIgnoreCase("scissors")){
				System.out.println("You chose Scissors.");
			}
			return playerRPS;
		}
		
		// Randomly choose a hand for computer.
		Random randNumGenerator = new Random();
		int computerRPS = randNumGenerator.nextInt(3);
		if (computerRPS == 0) {
	    System.out.println("Computer chose Rock.");
	  }
	  if (computerRPS == 1) {
	    System.out.println("Computer chose Paper.");
	  }
	  if (computerRPS == 2) {
	    System.out.println("Computer chose Scissors.");
	  }
	  // Print result.
	  if (playerRPS == computerRPS) {
	  	System.out.println("It's a tie!");
	  }
	  if ((playerRPS == 0) && (computerRPS == 1)) {
	  	System.out.println("Paper covers Rock. Computer wins!");
	  }
	  if ((playerRPS == 1) && (computerRPS == 2)) {
	  	System.out.println("Scissors cut Paper. Computer wins!");
	  }
	  if ((playerRPS == 2) && (computerRPS == 0)) {
	  	System.out.println("Rock smashes Scissors. Computer wins!");
	  }
	  if ((playerRPS == 0) && (computerRPS == 2)) {
	  	System.out.println("Rock smashes Scissors. Player wins!");
	  }
	  if ((playerRPS == 1) && (computerRPS == 0)) {
	  	System.out.println("Paper covers Rock. Player wins!");
	  }
	  if ((playerRPS == 2) && (computerRPS == 1)) {
	  	System.out.println("Scissors cut Paper. Player wins!");
	  }
	  reader.close();
	}

}
