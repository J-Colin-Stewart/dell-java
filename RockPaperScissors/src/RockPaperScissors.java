import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Introduction, set up for a nerd joke.
		System.out.println("SHALL WE PLAY A GAME?");
		System.out.println("I only play Rock, Paper Scissors.");
		System.out.print("So... Rock, paper, or scissors? ");
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
		
	// Get player choice and return it.
	public static String getPlayerChoice() {
		Scanner reader = new Scanner(System.in);
		String playerRPS = reader.next();
		if (playerRPS.equalsIgnoreCase("rock") || playerRPS.equalsIgnoreCase("paper") || playerRPS.equalsIgnoreCase("scissors")){
			return playerRPS;
		} 
		if (playerRPS.equalsIgnoreCase("global thermonuclear war")) {
			System.out.println("A STRANGE GAME.");
			System.out.println("THE ONLY WINNING MOVE IS");
			System.out.println("NOT TO PLAY.");
			System.out.println("HOW ABOUT A NICE GAME OF ROCK, PAPER, SCISSORS?");
			reader.close();
			getPlayerChoice();
		} 
		else {
			System.out.println("Not a valid choice. Please try again.");
			reader.close();
			getPlayerChoice();
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
	
	// Compare choices and declare a winner.
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

