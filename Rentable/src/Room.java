
public class Room implements Rentable { // A rentable room.
	
	String roomDesc; // Description of room
	double dailyRate; // Daily rental price of room.
	// Constructor
	public Room (String Description, double rentPerDay) {
		roomDesc = Description;
		dailyRate = rentPerDay;
	}
	// Return description of room.
	public String getDescription() {
		return roomDesc;
	}
	// Return daily rate of room retnal.
	public double getDailyRate() {
		return dailyRate;
	}
	// Return cost to rent room based on given number of days.
	public double getPrice(double days) {
		double price = dailyRate * days;
		price = Math.round(price * 100);
		price = price/100;
		return price;
	}

}
