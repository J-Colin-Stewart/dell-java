
public class Tool implements Rentable { // A rentable tool.
	
	String toolDesc; // Description of tool.
	double dailyRate; // Base daily rental price of tool.
	// Constructor.
	public Tool (String Description, double rentPerDay) {
		toolDesc = Description;
		dailyRate = rentPerDay;
	}
	// Return description of tool.
	public String getDescription() {
		return toolDesc;
	}
	// Return daily rate to rent tool.
	public double getDailyRate() {
		return dailyRate;
	}
	// Return weekly rate to rent tool (60% discount per week).
	public double getWeeklyRate() {
		double weekPrice = (dailyRate * 7) * 0.4;
		return weekPrice;
	}
	//Return cost to rent based on given number of days, rounded to 2 decimal points.
	public double getPrice(double days) {
		double price = dailyRate * days;
		if (days > 7) { // Calculation: for each full week, 60% discount applied in getWeeklyRate() applies. 
			price = (getWeeklyRate() + ((days%7) * (dailyRate*0.95))); // Any remaining days less than a full week get 5% discount.
		}
		price = Math.round(price * 100);
		price = price/100;
		return price;
	}

}
