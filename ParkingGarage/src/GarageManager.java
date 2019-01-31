import java.util.Scanner;
import java.util.InputMismatchException;

public class GarageManager {

	public static void main(String[] args) {
		
		ParkingGarage lot1 = new ParkingGarage();
		ParkingGarage lot2 = new ParkingGarage();
		ParkingGarage lot3 = new ParkingGarage();
		
		boolean exitCommand = false;
		Scanner input = new Scanner(System.in);
		int menuSelection = 0;		
		while (!(exitCommand)) {
			System.out.println();
			System.out.println("  VALET GARAGE MANAGER v0.1a");
			System.out.println("******************************");
			System.out.println("Spaces available in lot 1: " + lot1.availableSpaces());
			System.out.println("Spaces available in lot 2: " + lot2.availableSpaces());
			System.out.println("Spaces available in lot 3: " + lot3.availableSpaces());
			System.out.println("******************************");
			menuSelection = ParkingGarage.mainMenu(input);		
			
			switch (menuSelection) {
				case 1:
					boolean validLotPark = false;
					int parkingSpace = 9999;
					int parkingLot = 0;
					while (!(validLotPark)) {
						try {
							System.out.print("Check car in to which lot (1, 2, or 3)? ");
							parkingLot = input.nextInt();
							if (parkingLot == 1) {
								parkingSpace = ParkingGarage.parkCar(lot1, input);
							} else if (parkingLot == 2) {
								parkingSpace = ParkingGarage.parkCar(lot2, input);
							} else if (parkingLot == 3) {
								parkingSpace = ParkingGarage.parkCar(lot3, input);
							}	else {
								throw new InputMismatchException();
							}
						} catch (InputMismatchException e) {
							System.out.println("!!!Invalid entry - Please try again.");
							input.nextLine();
						} finally {
							validLotPark = true;
							if (parkingSpace != 9999) {
								System.out.println("PARKING ATTENDANT: PLEASE PARK CAR IN LOT " + parkingLot + ", SPACE " + parkingSpace);							
							}
						}
					}					
					break;
				case 2:
					ParkingGarage.retrieveAndClear(lot1, lot2, lot3, input);
					break;
				case 3:
					ParkingGarage.listInventory(lot1, lot2, lot3);
					break;
				case 4:
					boolean validLotSetup = false;
					while (!(validLotSetup)) {
						try {
							System.out.print("Which lot would you like to set current size for (1, 2, or 3)? ");
							int lotPicker = input.nextInt();
							if (lotPicker == 1) {
								ParkingGarage.setParkingSpaces(lot1, input);
							} else if (lotPicker == 2) {
								ParkingGarage.setParkingSpaces(lot2, input);
							} else if (lotPicker == 3) {
								ParkingGarage.setParkingSpaces(lot3, input);
							}	else {
								throw new InputMismatchException();
							}
						} catch (InputMismatchException e) {
							System.out.println("!!!Invalid entry - Please try again.");
							input.nextLine();
						} finally {
							validLotSetup = true;
						}
					}
					break;
				case 5:
					exitCommand = ParkingGarage.comfirmExit(input);
					break;					
			}
		}
	}
}
