
public class CarLotProgram {

	public static void main(String[] args) {
		// Instantiate 2 CarLot() objects with names specified..
		CarLot lot1 = new CarLot("First St - East Lot (New Cars)");
		CarLot lot2 = new CarLot("First St - West Lot (Used Cars)");
		// Instantiate numerous Car() and Truck() objects with all variables specified.
		Car car01 = new Car("Sedan", 4, "876-UH63", 2008, "Mercury", "Grand Marquis", 5499.99);
		Car car02 = new Car("Sedan", 4, "87Y-2RH3", 2014, "Ford", "Fiesta", 6149.99);
		Car car03 = new Car("Coupe", 2, "923-RRY3", 2019, "Ford", "Mustang", 36349.99);
		Car car04 = new Car("Hatchback", 5, "R76-3U7J", 2019, "Honda", "Fit", 16189.99);
		Car car05 = new Car("Coupe", 2, "R47-7HN3", 2015, "Honda", "Civic", 13799.99);
		Car car06 = new Car("Hatchback", 3, "876-UH63", 2017, "Mazda", "3", 15749.99);
		Car car07 = new Car("SUV", 5, "U7H-8792", 2016, "Toyota", "Highlander", 28769.99);
		Car car08 = new Car("Coupe", 2, "876-UH63", 2019, "Dodge", "Challenger", 28989.99);
		Car car09 = new Car("SUV", 5, "P67-RT64", 2017, "Honda", "CR-V", 22729.99);
		Car car10 = new Car("Sedan", 4, "Q78-9989", 2015, "Hundai", "Elantra", 11799.99);
		Car car11 = new Car("Hybrid", 4, "WF9-77T9", 2015, "Toyota", "Prius", 19474.99);
		Car car12 = new Car("Sedan", 4, "237-739H", 2019, "Honda", "Accord", 27719.99);
		Car car13 = new Car("Hovercar", 1, "ONE-WORD", 3011, "Ford", "ThunderCougarFalconBird", 3999999999.99);
		Car car14 = new Car("Coupe", 2, "HOMER-JS", 1991, "Powell", "Homer",  15221.91);
		Truck truck01 = new Truck(6, "99R-789C", 2016, "Chevrolet", "Silverado 1500", 31979.99);
		Truck truck02 = new Truck(5, "88C-97NR", 2012, "Ford", "F250", 21239.99);
		Truck truck03 = new Truck(5, "YY7-MN76", 2019, "GMC", "Sierra 1500", 56194.99);
		Truck truck04 = new Truck(5, "RT6-OP7N", 2015, "Dodge", "Ram 1500", 30569.99);
		Truck truck05 = new Truck(6, "L7R-RR9N", 2012, "Ford", "F150", 12129.99);
		// Add all Vehicle() objects to a lot.
		lot2.addVehicle(car01);
		lot2.addVehicle(car02);
		lot1.addVehicle(car03);
		lot1.addVehicle(car04);
		lot2.addVehicle(car05);
		lot2.addVehicle(car06);
		lot2.addVehicle(car07);
		lot1.addVehicle(car08);
		lot2.addVehicle(car09);
		lot2.addVehicle(car10);
		lot2.addVehicle(car11);
		lot1.addVehicle(car12);
		lot1.addVehicle(car13);
		lot2.addVehicle(car14);
		lot2.addVehicle(truck01);
		lot2.addVehicle(truck02);
		lot1.addVehicle(truck03);
		lot2.addVehicle(truck04);
		lot2.addVehicle(truck05);		
		// Print inventory for each lot.
		CarLot.printInventory(lot1);
		CarLot.printInventory(lot2);
	}

}
