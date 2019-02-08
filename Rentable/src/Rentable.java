
public interface Rentable { // Interface for required method implementation in other classes.
	// Description of rentable object.
	String getDescription();
	// Daily cost to rent object.
	double getDailyRate();
	// Cost based on number of days rented.
	double getPrice(double days);	
	
}
