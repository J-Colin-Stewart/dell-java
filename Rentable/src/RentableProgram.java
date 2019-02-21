import java.util.Scanner;

public class RentableProgram { // Program to drive Rentable implementation.

	public static void main(String[] args) {
		// Description of rentals, including discounts if available.
		System.out.println("RENT CALCULATOR");
		System.out.println("Discounted weekly rates!");
		System.out.println("ROOMS: No current weekly discount. Full day rate per day.");
		System.out.println("CONDOS: 15% off if over a week, 5% off each additional day!");
		System.out.println("TOOLS: 60% off day rate for week rent, 5% off each additional day!");
		// Instantiate an array of Rentable items and open the Scanner input.
		Rentable[] thingsToRent = new Rentable[9];
		Scanner in = new Scanner(System.in);
		// Instantiate a few Room types available to rent, providing description and daily rate to rent.
		Room room1 = new Room("Room, 1 Twin bed, Shower/tub, mini-fridge", 27.95);
		Room room2 = new Room("Room, 2 Queen beds, Shower w/ Garden tub, kitchenette", 88.75);
		Room room3 = new Room("Room, 1 King bed, Standing shower/separate jacuzzi, full kitchen", 156.89);
		// Instantiate a few Condo types available to rent, providing description and daily rate to rent.
		Condo condo1 = new Condo("Condo, 800 Sqft, 1 BR 1 Bath, King bed, pull-out couch w/ Twin, kitchenette", 229.65);
		Condo condo2 = new Condo("Condo, 1560 SqFt, 2 BR 2.5 Bath, King bed, Queen bed, full kitchen", 295.65);
		Condo condo3 = new Condo("Condo, 2475 SqFt, 3 BR 3.5 Bath, 2 King bed 1 Queen bed, large kitchen, garage", 429.55);
		// Instantiate a few Tool types available to rent, providing description and daily rate to rent.
		Tool tool1 = new Tool("Tool, Power Drill", 9.95);
		Tool tool2 = new Tool("Tool, Chainsaw", 15.75);
		Tool tool3 = new Tool("Tool, Bobcat", 675.85);
		// Add Rentable objects to array to simplify print method by iteration.
		thingsToRent[0] = room1;
		thingsToRent[1] = room2;
		thingsToRent[2] = room3;
		thingsToRent[3] = condo1;
		thingsToRent[4] = condo2;
		thingsToRent[5] = condo3;
		thingsToRent[6] = tool1;
		thingsToRent[7] = tool2;
		thingsToRent[8] = tool3;
		// Request input of days to rent to perform cost calculation, then show cost for those days for any Rentable object in array.
		System.out.print("How many days to rent? ");
		int daysToRent = in.nextInt();
		System.out.println();
		
		for (int i = 0; i < thingsToRent.length; i++) {
			String desc = thingsToRent[i].getDescription();
			double dayRate = thingsToRent[i].getDailyRate();
			double finalPrice = thingsToRent[i].getPrice((double)daysToRent);
			System.out.println("Description: " + desc + " | Reg. Daily rate: " + dayRate + " | Price for " + daysToRent + " days: $" + finalPrice);
		}
		in.close(); // Close Scanner.

	}

}
