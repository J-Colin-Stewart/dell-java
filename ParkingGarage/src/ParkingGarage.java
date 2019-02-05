import java.util.Scanner;
import java.util.InputMismatchException;

public class ParkingGarage {
	
	public boolean[] parkingSpaces; // Attribute array to determine if parking spots are in use.
	public Car[] parkedCars; // To hold attributes of car in each space, set to same index as parking space.
	
	public ParkingGarage() {}
	// Helper method to dynamically update available spaces in GarageManager main, or show when not set up.
	public String availableSpaces() {
		int spacesCounter = 0;
		String spacesAvailable = "";		
		try {			
			for (int i = 0; i < this.parkingSpaces.length; i++) {
				if (this.parkingSpaces[i] == false) {
					spacesCounter = spacesCounter + 1;
				}
			}
			if (spacesCounter == 0) {
				spacesAvailable = "*** LOT IS FULL ***";
			} else if (spacesCounter != 0) {			
				spacesAvailable = spacesCounter + " spaces available";
			}			
		} catch (NullPointerException e) {
			spacesAvailable = "PLEASE SET LOT SIZE (OPTION 4)";
		}
		return spacesAvailable;
	}	
	// The main menu. Returns selection to main GarageManager method to perform requested operation.
	public static int mainMenu(Scanner menuChoice) {
		int selection = 0;
		boolean validMenu = false;
		while (!(validMenu)) {
			try {
				System.out.println("PLEASE SELECT ONE OF THE FOLLOWING OPTIONS:");
				System.out.println("1. Check car in");
				System.out.println("2. Check car out");
				System.out.println("3. List cars currently parked");
				System.out.println("4. Set lot size (3 lots available)");
				System.out.println("5. Exit program (Close of day)");
				System.out.print("SELECTION: ");		
				selection = menuChoice.nextInt();
				validMenu = true;
			} catch (InputMismatchException e) {
				System.out.println("!!!Invalid entry - Please try again.");
				menuChoice.nextLine();
			}
		}
		return selection;
	}
	// Lot selection method, sends selection to parkCar() helper method and gives parking instructions to attendant.
	public static void sendToPark(ParkingGarage firstLot, ParkingGarage secondLot, ParkingGarage thirdLot, Scanner pickLot) {
		boolean validLotPark = false;
		int parkingSpace = 9999;
		int parkingLot = 0;
		while (!(validLotPark)) {
			try {
				System.out.print("Check car in to which lot (1, 2, or 3)? ");
				parkingLot = pickLot.nextInt();
				if (parkingLot == 1) {
					parkingSpace = parkCar(firstLot, pickLot);
				} else if (parkingLot == 2) {
					parkingSpace = parkCar(secondLot, pickLot);
				} else if (parkingLot == 3) {
					parkingSpace = parkCar(thirdLot, pickLot);
				}	else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("!!!Invalid entry - Please try again.");
				pickLot.nextLine();
			} finally {
				validLotPark = true;
				if (parkingSpace != 9999) { // Bypasses parking attendant instruction if parkCar() fails to function normally.
					System.out.println("PARKING ATTENDANT: PLEASE PARK CAR IN LOT " + parkingLot + ", SPACE " + parkingSpace);							
				}
			}
		}
	}
	// Private helper method to mark space in use and get attributes of Car to be parked. Returns space number to sendToPark().
	private static int parkCar(ParkingGarage thisLot, Scanner pass) {
		int valetToThisSpace = 9999;
		try {
			Car toPark = new Car();		
			toPark.setParkedIn(thisLot);
			toPark.ValetTicket = Car.setValetTicket();
			pass.nextLine();
			toPark.Make = Car.setMake(pass);
			toPark.Model = Car.setModel(pass);
			toPark.Color = Car.setColor(pass);
			toPark.LicenseNum = Car.setLicenseNum(pass);
			toPark.isVIP = Car.setVIP(pass);
			valetToThisSpace = toPark.parkedIn;
			thisLot.parkedCars[valetToThisSpace] = toPark;
			System.out.println();
			System.out.println("VALET TICKET: " + toPark.getValetTicket() + " | LICENSE PLATE: " + toPark.getLicenseNum() +  " | VIP SERVICE: " + toPark.getVIP());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("****************************************************");
			System.out.println("*  !!! ERROR !!!  Selected lot is not set up yet!  *");
			System.out.println("* Use option 4 from main menu to set up lot first! *");
			System.out.println("****************************************************");
		}
		return valetToThisSpace;
	}
	// Method to retrieve parked car from Valet Ticket #. If entry is valid, uses helper method clearParkingSpace() to confirm check-out.
	public static void retrieveAndClear(ParkingGarage firstLot, ParkingGarage secondLot, ParkingGarage thirdLot, Scanner findTicket) {
		boolean validTicket = false;
		while (!(validTicket)) {		
			try {			
				boolean ticketFound = false;
				System.out.println();
				System.out.println("Please enter Valet Ticket number for parked vehicle: ");
				int ticketFinder = findTicket.nextInt();
				if (firstLot.parkingSpaces == null) {
					System.out.println("Lot 1 is not set up! Searching lot 2...");
				} else {
					try {
						for (int i = 0; i < firstLot.parkingSpaces.length; i++) {
							if (firstLot.parkedCars[i].getValetTicket() == ticketFinder) {
								ticketFound = true;
								int lotID = 1;
								clearParkingSpace(firstLot, lotID, i, findTicket);
								return;
							}
						}
					} catch (NullPointerException npe) {
						System.out.println("Not found in lot 1. Searching lot 2...");
					}
				}
				if (secondLot.parkingSpaces == null) {
					System.out.println("Lot 2 is not set up! Searching lot 3...");
				} else {
					try {
						for (int i = 0; i < secondLot.parkingSpaces.length; i++) {
							if (secondLot.parkedCars[i].getValetTicket() == ticketFinder) {
								ticketFound = true;
								int lotID = 2;
								clearParkingSpace(secondLot, lotID, i, findTicket);
								return;
							}
						}
					} catch (NullPointerException npe) {
						System.out.println("Not found in lot 2. Searching lot 3...");
					}
				}
				if (thirdLot.parkingSpaces == null) {
					System.out.println("Lot 3 is not set up! Returning to Main Menu.");
				} else {
					try {
						for (int i = 0; i < thirdLot.parkingSpaces.length; i++) {
							if (thirdLot.parkedCars[i].getValetTicket() == ticketFinder) {
								ticketFound = true;
								int lotID = 3;
								clearParkingSpace(thirdLot, lotID, i, findTicket);
								return;
							}
						}
					} catch (NullPointerException npe) {
						System.out.println("Not found in lot 3. Please verify ticket number.");
						System.out.println("Returning to Main Menu.");
					}
				}
				if (ticketFound == false) {
					System.out.println();
					System.out.println("TICKET NUMBER NOT FOUND!");
					System.out.println("Please re-check number, or use option 3 to view all parked vehicles.");
				}
				validTicket = true;
			} catch (InputMismatchException e) {
				System.out.println("!!! WARNING !!! Invalid entry - Please try again.");
				findTicket.nextLine();
			}
		}
	}
	// Private helper method, uses validated request from retrieveAndClear() and confirms check-out with challenge/response, then resets the parkingSpaces and parkedCars arrays at space index.
	private static void clearParkingSpace(ParkingGarage thisLot, int lot, int spaceNumber, Scanner confirm) {
		boolean confirmRetrieve = false;
		while (!(confirmRetrieve)) {
			try {				
				System.out.println("Ticket found - Are you sure you wish to check out");
				System.out.println("and retrieve car for valet ticket #" + thisLot.parkedCars[spaceNumber].getValetTicket() + "?");
				System.out.print("To confirm, type 999 and press Enter: "); // low-complexity challenge/response to proceed.
				int conf = confirm.nextInt();
				if (conf == 999) {
					System.out.println();
					System.out.println("VALET TICKET: " + thisLot.parkedCars[spaceNumber].getValetTicket() + " | LICENSE PLATE: " + thisLot.parkedCars[spaceNumber].getLicenseNum() +  " | VIP SERVICE: " + thisLot.parkedCars[spaceNumber].getVIP());
					System.out.println("PARKING ATTENDANT: PLEASE RETRIEVE CAR IN LOT " + lot + ", SPACE " + thisLot.parkedCars[spaceNumber].getParkedIn());
					thisLot.parkingSpaces[spaceNumber] = false;
					thisLot.parkedCars[spaceNumber] = null;
					confirmRetrieve = true;
				} else {
					System.out.println();
					System.out.println("Check out cancelled.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("!!! WARNING !!! Invalid entry - Please try again.");
				confirm.nextLine(); // Necessary reset after Scanner takes a nextInt.
			}
		}
	}
	// Lot selector to set currently available size. Passes lot choice to method setParkingSpaces() once selection is validated.
	public static void setUpLot (ParkingGarage firstLot, ParkingGarage secondLot, ParkingGarage thirdLot, Scanner pickLot) {
		boolean validLotSetup = false;
		while (!(validLotSetup)) {
			try {
				System.out.print("Which lot would you like to set current size for (1, 2, or 3)? ");
				int lotPicker = pickLot.nextInt();
				if (lotPicker == 1) {
					ParkingGarage.setParkingSpaces(firstLot, pickLot);
				} else if (lotPicker == 2) {
					ParkingGarage.setParkingSpaces(secondLot, pickLot);
				} else if (lotPicker == 3) {
					ParkingGarage.setParkingSpaces(thirdLot, pickLot);
				}	else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("!!!Invalid entry - Please try again.");
				pickLot.nextLine();
			} finally {
				validLotSetup = true;
			}
		}
	}
	// Private helper method, sets lot size for lot selected in setUpLot(). If a lot size is already set, challenge/response to confirm data reset with attribute change.
	private static void setParkingSpaces(ParkingGarage thisLot, Scanner spacesChoice) {
		boolean validSpaces = false;
		int confirmChange = 0;
		if (thisLot.parkingSpaces != null) {
			System.out.println();
			System.out.println("************************************************************");
			System.out.println("* !!! WARNING !!! Changing lot size will clear all spaces! *");
			System.out.println("*       You will need to re-enter all parked cars          *");
			System.out.println("*       and valet ticket numbers will be changed!          *");
			System.out.println("************************************************************");
			System.out.print("DO YOU STILL WISH TO CHANGE LOT SIZE? Type 97531 and press Enter to continue: ");
			confirmChange = spacesChoice.nextInt();
			if (confirmChange != 97531) { // Medium-complexity challenge/response to proceed, due to possibility of data loss.
				validSpaces = true;
			}
		}		
		while (!(validSpaces)) {
			try {
				System.out.print("How many usable spaces now in this lot? ");			
				int thisMany = spacesChoice.nextInt();
				validSpaces = true;			
				boolean[] thisManySpaces = new boolean[thisMany];
				Car[] carPlaceHolder = new Car[thisMany];
				thisLot.parkingSpaces = thisManySpaces;
				thisLot.parkedCars = carPlaceHolder;
			} catch (InputMismatchException e) {
				System.out.println("!!! WARNING !!! Invalid entry - Please try again.");
				spacesChoice.nextLine();
			}	
		}
	}
	// Lists currently parked cars in all lots and spaces, with all accompanying attributes.
	public static void listInventory(ParkingGarage firstLot, ParkingGarage secondLot, ParkingGarage thirdLot) {
		int space = 0;
		int ticket = 0;
		String plate = "";
		String VIP = "";
		String colorMakeModel = "";
		System.out.println();
		System.out.println("<<<<< LOT 1 >>>>>");
		if (firstLot.parkingSpaces == null) {
			System.out.println("*** LOT IS NOT IN USE ***");
		} else {
			System.out.println("SPACE  TICKET  LICENSEPLATE  VIP  COLOR/MAKE/MODEL");
			for (int i = 0; i < firstLot.parkingSpaces.length; i++) {
				if (firstLot.parkingSpaces[i] == true) {
					space = firstLot.parkedCars[i].getParkedIn();
					ticket = firstLot.parkedCars[i].getValetTicket();
					plate = firstLot.parkedCars[i].getLicenseNum();
					VIP = firstLot.parkedCars[i].getVIP();
					colorMakeModel = firstLot.parkedCars[i].getColorMakeModel();
					System.out.println("  "+space+"     "+ticket+"     "+plate+"     "+VIP+"    "+colorMakeModel);
				}
			}
		}
		System.out.println("<<<<< LOT 2 >>>>>");
		if (secondLot.parkingSpaces == null) {
			System.out.println("*** LOT IS NOT IN USE ***");
		} else {
			System.out.println("SPACE  TICKET  LICENSEPLATE  VIP  COLOR/MAKE/MODEL");
			for (int i = 0; i < secondLot.parkingSpaces.length; i++) {
				if (secondLot.parkingSpaces[i] == true) {
					space = secondLot.parkedCars[i].getParkedIn();
					ticket = secondLot.parkedCars[i].getValetTicket();
					plate = secondLot.parkedCars[i].getLicenseNum();
					VIP = secondLot.parkedCars[i].getVIP();
					colorMakeModel = secondLot.parkedCars[i].getColorMakeModel();
					System.out.println("  "+space+"     "+ticket+"     "+plate+"     "+VIP+"    "+colorMakeModel);
				}
			}
		}
		System.out.println("<<<<< LOT 3 >>>>>");
		if (thirdLot.parkingSpaces == null) {
			System.out.println("*** LOT IS NOT IN USE ***");
		} else {
			System.out.println("SPACE  TICKET  LICENSEPLATE  VIP  COLOR/MAKE/MODEL");
			for (int i = 0; i < thirdLot.parkingSpaces.length; i++) {
				if (thirdLot.parkingSpaces[i] == true) {
					space = thirdLot.parkedCars[i].getParkedIn();
					ticket = thirdLot.parkedCars[i].getValetTicket();
					plate = thirdLot.parkedCars[i].getLicenseNum();
					VIP = thirdLot.parkedCars[i].getVIP();
					colorMakeModel = thirdLot.parkedCars[i].getColorMakeModel();
					System.out.println("  "+space+"     "+ticket+"     "+plate+"     "+VIP+"    "+colorMakeModel);
				}
			}
		}		
	}	
	// Validates main menu selection to exit program. Complex challenge/response to avoid data loss.
	public static boolean comfirmExit(Scanner confirm) {
		boolean exitConfirm = false;
		int JENNY = 0; // This will make sense in a second.
		System.out.println();
		System.out.println("************************************************************");
		System.out.println("* !!! WARNING !!! Exiting the program clears all check-ins *");
		System.out.println("*       And resets the Valet Ticket counter to 100.        *");
		System.out.println("* Use ONLY at close of business or if all lots are empty!! *");
		System.out.println("************************************************************");
		System.out.print("DO YOU WISH TO EXIT AND CLOSE OUT? Type 8675309 and press Enter to continue: "); // Challenge/response. Also haha :)
		try {
			JENNY = confirm.nextInt();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("That isn't Jenny's number! Please re-check bathroom stall.");
			confirm.nextLine();
		}
		if (JENNY == 8675309) { // JEEEENNY I GOT YOUR NUMBER
			exitConfirm = true;
			System.out.println();
			System.out.println("Program exit is confirmed. Day is closed out. See you next time!");
			return exitConfirm;
		} else {
			System.out.println();
			System.out.println("Exit confirmation failed! Returning to Main Menu.");
			return exitConfirm;
		}
	}
}
