import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.InputMismatchException;

public class Car {
	
	public int ValetTicket;
	public String Make;
	public String Model;
	public String Color;
	public String LicenseNum;	
	public boolean isVIP;
	public int parkedIn;
	
	public Car() {}
	
	private static final AtomicInteger count = new AtomicInteger(100);
	
	public int getValetTicket() {
		return this.ValetTicket;
	}
	public static int setValetTicket() {
		int valetTicket = count.incrementAndGet();
		return valetTicket;
	}
	
	public String getColorMakeModel() {
		String concatAttribs = this.Color + "/" + this.Make + "/" + this.Model;
		return concatAttribs;
	}
	public static String setMake(Scanner input) {
		System.out.print("Make: ");
		String carMake = input.nextLine();
		return carMake;
	}
	public static String setModel(Scanner input) {
		System.out.print("Model: ");
		String carModel = input.nextLine();
		return carModel;
	}
	public static String setColor(Scanner input) {
		System.out.print("Color: ");
		String carColor = input.nextLine();
		return carColor;
	}
	public String getLicenseNum() {
		return this.LicenseNum;
	}
	public static String setLicenseNum(Scanner input) {
		System.out.print("License Plate: ");
		String carLicensePlate = input.nextLine();
		return carLicensePlate;
	}
	
	public String getVIP() {
		String VIPFlag = "NO";
		if (this.isVIP) {
			VIPFlag = "YES";
			return VIPFlag;
		} else {
			return VIPFlag;
		}
	}
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
			}
		}
		return VIPStatus;
	}
	
	public int getParkedIn() {
		return this.parkedIn;
	}
	
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
