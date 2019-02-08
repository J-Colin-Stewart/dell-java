
public class Condo implements Rentable { // A rentable condominium.
	
	String condoDesc; // Description of condo.
	double dailyRate; // Base daily rental price of condo.
	// Constructor.
	public Condo (String Description, double rentPerDay) {
		condoDesc = Description;
		dailyRate = rentPerDay;
	}
	// Return description of condo.
	public String getDescription() {
		return condoDesc;
	}
	// Return daily rate to rent condo.
	public double getDailyRate() {
		return dailyRate;
	}
	// Return weekly rate to rent condo (15% discount per week).
	public double getWeeklyRate() {
		double weekPrice = (dailyRate * 7) * 0.85;
		return weekPrice;
	}
	// Return cost to rent based on given number of days, rounded to 2 decimal points.
	public double getPrice(double days) {
		double price = dailyRate * days;
		if (days > 7) { // Calculation: for each full week, 15% discount applied in getWeeklyRate() applies. 
			price = (getWeeklyRate() + ((days%7) * dailyRate)) * 0.95; // Any remaining days less than a full week get 5% discount.
		}
		price = Math.round(price * 100);
		price = price/100;
		return price;
	}

}
