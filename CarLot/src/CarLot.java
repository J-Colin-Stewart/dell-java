import java.util.ArrayList;

public class CarLot {
	// Each car lot has a descriptive name and a list of vehicles.
	public String name;
	public ArrayList<Vehicle> vehicles;
	// Empty constructor.
	public CarLot() {}
	// Constructor which allows creation with lot name included.
	public CarLot(String lotName) {
		name = lotName;
		vehicles = new ArrayList<Vehicle>(0);
	}
	// Allows addition of vehicles to a lot.
	public void addVehicle(Vehicle thisVehicle ) {
		this.vehicles.add(thisVehicle);
	}
	// Prints current inventory for given lot.
	public static void printInventory(CarLot thisLot) {
		System.out.println("Lot name: " + thisLot.name);
		System.out.println("************* Start of inventory *************");	
		for (int i=0; i < thisLot.vehicles.size(); i++) {
			thisLot.vehicles.get(i).printDesc();
		}
		System.out.println("************** End of inventory **************");
		System.out.println();
	}

}
