
public abstract class Vehicle {
	// Variables common to all Vehicle class elements and extended classes.
	public String licenseNum;
	public int year;
	public String make;
	public String model;
	public double price;
	// Empty constructor.
	public Vehicle() {}
	// Overloaded constructor.
	public Vehicle(String vLicenseNum, int vYear, String vMake, String vModel, double vPrice) {	
		licenseNum = vLicenseNum;
		year = vYear;
		make = vMake;
		model = vModel;
		price = vPrice;
	}
	// Super method to print descriptive elements common to this class and extended classes.
	public void printDesc() {
		System.out.println("License Plate: " + this.licenseNum
				+ " Year: " + this.year
				+ "  Make: " + this.make
				+ "  Model: " + this.model
				+ "  Price: $" + this.price);
	}
	
}


