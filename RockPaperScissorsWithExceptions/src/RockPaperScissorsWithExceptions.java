import java.util.Random;
import java.util.Scanner;
// Adding a change because my commit comment didn't catch. D'oh!
public class RockPaperScissorsWithExceptions {

	public static void main(String[] args) {
		// Introduction, set up for a nerd joke.
		System.out.println("SHALL WE PLAY A GAME?");
		System.out.println("I only play Rock, Paper Scissors.");		
		letsPlay();
	}
	
	// Method containing gameplay.
	public static void letsPlay() {
		boolean isInvalid = true;
		while (isInvalid) { // Loop will break and reset if either of the validation methods throw an exception.
			try {
			  System.out.print("So... Rock, Paper or Scissors? ");
				Scanner reader = new Scanner(System.in);
				String playerChoice = reader.nextLine();
				checkForJoke(playerChoice); // Let's see if the set up for the joke worked
				checkPlayerChoice(playerChoice); // If it didn't, let's validate for RPS input.
				reader.close();
				System.out.println("You chose: " + playerChoice);
				String computerChoice = getComputerChoice();
				System.out.println("Computer chose: " + computerChoice);
				String winMessage = getWinner(playerChoice, computerChoice);
				System.out.print(winMessage);
				isInvalid = false;
			} catch(IllegalStateException e) {
				System.out.println(e.toString());
			} catch(IllegalArgumentException e) {
				System.out.println(e.toString());
			}			
		}
	}
	
  // If the player got the joke and tried any input containing the word "war", shows an easter egg and throws an exception to ask for RPS again.
	public static void checkForJoke(String playerChoice) {
		String[] splitUpSentence = playerChoice.split("\\s+"); //Splits a sentence into a string array, using space as delimiter.
		for (int i = 0; i < splitUpSentence.length; i++) {
			if (splitUpSentence[i].equalsIgnoreCase("war")) {
				System.out.println("A STRANGE GAME."); // There's that War Games quote :)
				System.out.println("THE ONLY WINNING MOVE IS");
				System.out.println("NOT TO PLAY.");
				throw new IllegalStateException("HOW ABOUT A NICE GAME OF ROCK, PAPER, SCISSORS?");
			}	
		}		
	}
		
	// Validate the player's choice. Throws an exception if it isn't rock, paper or scissors.
	public static void checkPlayerChoice(String playerChoice) {
		if (!(playerChoice.equalsIgnoreCase("rock") || playerChoice.equalsIgnoreCase("paper") || playerChoice.equalsIgnoreCase("scissors"))){
			throw new IllegalArgumentException("Not a valid choice. Please try again.");
		} 					
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
	
	// Compare choices and declare a winner (verbose). Ignores upper/lowercase for all checked strings.
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

