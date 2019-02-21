import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Introduction.
		System.out.println("Let's play Rock, Paper Scissors.");
		System.out.print("Do you choose Rock, Paper or Scissors? ");
		letsPlay();
	}
	
	// Method containing gameplay.
	public static void letsPlay() {
		String playerChoice = getPlayerChoice();
		System.out.println("You chose: " + playerChoice);
		String computerChoice = getComputerChoice();
		System.out.println("Computer chose: " + computerChoice);
		String winMessage = getWinner(playerChoice, computerChoice);
		System.out.print(winMessage);
	}
		
	// Get player choice input and return it. If not equal to rock, paper or scissors, will ask until valid choice given.
	public static String getPlayerChoice() {
		Scanner reader = new Scanner(System.in);
		String playerRPS = reader.next();
		while (!(playerRPS.equalsIgnoreCase("rock") || playerRPS.equalsIgnoreCase("paper") || playerRPS.equalsIgnoreCase("scissors"))){
			System.out.println("Not a valid choice. Please try again.");
			System.out.print("Rock, Paper or Scissors? ");
			playerRPS = reader.next();
		}
		reader.close();
		return playerRPS;
	}
		
	// Randomly choose a hand for computer and return it as a string.
	public static String getComputerChoice() {
		Random randNumGenerator = new Random();
		int i = randNumGenerator.nextInt(3);
		String computerRPS = "";
		if (i == 0) {
		   computerRPS = "Rock";
		 }
		 if (i == 1) {
		   computerRPS = "Paper";
		 }
		 if (i == 2) {
		   computerRPS = "Scissors";
		 }
		 return computerRPS;
	}
	
	// Compare choices and declare a winner (verbose).
	public static String getWinner(String playerChoice, String computerChoice) {
		if (playerChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("paper")) {
			System.out.println("Paper covers Rock. ");
			return ("Computer wins!");
		}
		if (playerChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("scissors")) {
			System.out.println("Scissors cut Paper. ");
			return ("Computer wins!");
		}
		if (playerChoice.equalsIgnoreCase("scissors") && computerChoice.equalsIgnoreCase("rock")) {
			System.out.println("Rock smashes Scissors. ");
			return ("Computer wins!");
		}
		if (playerChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("scissors")) {
			System.out.println("Rock smashes Scissors. ");
			return("Player wins!");
		}
		if (playerChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("rock")) {
			System.out.println("Paper covers Rock. ");
			return ("Player wins!");
		}
		if (playerChoice.equalsIgnoreCase("scissors") && computerChoice.equalsIgnoreCase("paper")) {
			System.out.println("Scissors cut Paper. ");
			return ("Player wins!");
		}
		else {
			return("It's a tie!");
		}
	}
}

