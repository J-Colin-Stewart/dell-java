
public class Car extends Vehicle {
	// Variables specific to Car class which extends Vehicle class.
	public String carType;
	public int numDoors;
	// Empty Car() constructor.
	Car () {}
	// Overloaded Car() constructor, calls overloaded constructor for Vehicle Super class as well.
	public Car(String vCarType, int vNumDoors, String vLicenseNum, int vYear, String vMake, String vModel, double vPrice) {	
		super(vLicenseNum, vYear, vMake, vModel, vPrice);
		carType = vCarType;
		numDoors = vNumDoors;
	}
	// Print description elements for Car and call print description for Vehicle Super Class for common element variables.
	public void printDesc() {		
		System.out.println("> Type: " + this.carType
				+ " Doors: " + this.numDoors);
		super.printDesc();
	}

}
