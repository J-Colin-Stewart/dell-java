import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.InputMismatchException;

public class Car {
	// Lots of nifty attributes.
	public int ValetTicket;
	public String Make;
	public String Model;
	public String Color;
	public String LicenseNum;	
	public boolean isVIP;
	public int parkedIn;
	
	public Car() {} // Initialized null because attributes are dynamically set and null is used to reset.
	
	private static final AtomicInteger count = new AtomicInteger(100); // This thing is cool. Thanks Google!
	
	public int getValetTicket() {
		return this.ValetTicket;
	}
	//Each time a Car is instantiated, increments AtomicInteger by 1 and returns that value for the valet ticket number.
	public static int setValetTicket() {
		int valetTicket = count.incrementAndGet();
		return valetTicket;
	}
	// Returns a concatenated string of Color, Make and Model. They are never used separately.
	public String getColorMakeModel() {
		String concatAttribs = this.Color + "/" + this.Make + "/" + this.Model;
		return concatAttribs;
	}
	// Asks for Make and returns it to ParkingGarage.parkCar().
	public static String setMake(Scanner input) {
		System.out.print("Make: ");
		String carMake = input.nextLine();
		return carMake;
	}
	// Asks for Model and returns it to ParkingGarage.parkCar().
	public static String setModel(Scanner input) {
		System.out.print("Model: ");
		String carModel = input.nextLine();
		return carModel;
	}
	// Asks for Color and returns it to ParkingGarage.parkCar().
	public static String setColor(Scanner input) {
		System.out.print("Color: ");
		String carColor = input.nextLine();
		return carColor;
	}
	// Returns the license plate number.
	public String getLicenseNum() {
		return this.LicenseNum;
	}
	// Asks for License Plate and returns it to ParkingGarage.parkCar()
	public static String setLicenseNum(Scanner input) {
		System.out.print("License Plate: ");
		String carLicensePlate = input.nextLine();
		return carLicensePlate;
	}
	// Returns the VIP status.
	public String getVIP() {
		String VIPFlag = "NO";
		if (this.isVIP) {
			VIPFlag = "YES";
			return VIPFlag;
		} else {
			return VIPFlag;
		}
	}
	// Sets and validates VIP status when checking in to Valet. Seemed like a useful feature.
	public static boolean setVIP(Scanner input) {
		boolean VIPStatus = false;
		boolean checkThis = false;
		while (!(checkThis)) {
			try {
				System.out.print("VIP status (1=YES, 2=NO): ");
				int choice = input.nextInt();
				if (choice == 1) {
					VIPStatus = true;
					checkThis = true;
				} else if (choice == 2) {
					VIPStatus = false;
					checkThis = true;
				}
			} catch(InputMismatchException e) {
				System.out.println("!!!Invalid selection - Try again");
				input.nextLine();
			}
		}
		return VIPStatus;
	}
	// Returns the parking space index in the array of ParkingGarage.parkedCars[] where the car is parked.
	public int getParkedIn() {
		return this.parkedIn;
	}
	// Finds the first "available" (false) space in ParkingGarage.parkingSpaces[] array, marks it as true and returns it to ParkingGarage.parkCar().
	public void setParkedIn(ParkingGarage thisGarage) {
		for (int i = 0; i < thisGarage.parkingSpaces.length; i++) {
			if (thisGarage.parkingSpaces[i] == false) {
				thisGarage.parkingSpaces[i] = true;
				this.parkedIn = i;
				return;
			}
		}		
	}
	

}
