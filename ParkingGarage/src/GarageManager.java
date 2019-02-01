import java.util.Scanner;

public class GarageManager {

	public static void main(String[] args) {
		// Parking garage objects, un-initialized so that custom size can be set by option 4 below.
		// Once initialized and size set, contains a boolean array (space in use t/f) and a Car array.
		ParkingGarage lot1 = new ParkingGarage();
		ParkingGarage lot2 = new ParkingGarage();
		ParkingGarage lot3 = new ParkingGarage();
		
		boolean exitCommand = false; // exitCommand is made true by Main Menu option 5 (exits program).
		Scanner input = new Scanner(System.in); // Scanner is passed from here to all other objects/methods.
		int menuSelection = 0; // Holds the main menu selection.
		while (!(exitCommand)) {
			System.out.println();
			System.out.println("  VALET GARAGE MANAGER v0.1a");
			System.out.println("******************************");
			System.out.println("Spaces available in lot 1: " + lot1.availableSpaces()); 
			System.out.println("Spaces available in lot 2: " + lot2.availableSpaces()); // Updates when main while loop repeats.
			System.out.println("Spaces available in lot 3: " + lot3.availableSpaces());
			System.out.println("******************************");
			menuSelection = ParkingGarage.mainMenu(input); // Above is dynamic, but main menu is static, so use helper method to print and retrieve choice.
			
			switch (menuSelection) {
				case 1: // Gets inputs for Car variables to park and parks it, if chosen lot is set up.
					ParkingGarage.sendToPark(lot1, lot2, lot3, input);										
					break;
				case 2: // Retrieve Car by searching Valet ticket#, with challenge/response to confirm.
					ParkingGarage.retrieveAndClear(lot1, lot2, lot3, input);
					break;
				case 3: // List currently parked cars in all lots.
					ParkingGarage.listInventory(lot1, lot2, lot3);
					break;
				case 4: // Set up a lot for daily use, or update available spaces in lot with challenge/response to avoid data loss.
					ParkingGarage.setUpLot(lot1, lot2, lot3, input);					
					break;
				case 5: // Exits the program, confirmed by a challenge/response.
					exitCommand = ParkingGarage.comfirmExit(input);
					break;					
			}
		}
	}
}
