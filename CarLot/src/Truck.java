
public class Truck extends Vehicle {
	// Variable specific to Truck which extends Vehicle class.
	public int bedLength;
	// Emtpy Truck() Constructor.
	Truck() {}
	// Overloaded Truck() constructor, calls overloaded constructor for Vehicle Super class as well.
	public Truck(int vBedLength, String vLicenseNum, int vYear, String vMake, String vModel, double vPrice) {
		super(vLicenseNum, vYear, vMake, vModel, vPrice);
		bedLength = vBedLength;
	}	
	//Print description elements for Truck and call print description for Vehicle Super Class for common element variables.
	public void printDesc() {
		System.out.println("> Type: Truck " // Included static type "Truck" to mirror formatting for Car().
				+ " Bed length: " + this.bedLength + "ft.");
		super.printDesc();
	}
}
