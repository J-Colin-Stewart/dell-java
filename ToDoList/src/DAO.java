import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAO {
	// Data Access Object incorporates an ArrayList
	private static List<ToDoItem> database;
	// Constructor instantiates with a blank ArrayList
	DAO() {
		database = new ArrayList<>();
	}
	// Method to add a new 'To Do' task
	public void add(Scanner addThis) {
		System.out.print("Task description: ");
		String desc = addThis.nextLine(); // Get the user input of description
		ToDoItem newItem = new ToDoItem(desc); // Hand the description to the consructor
		database.add(newItem);
		System.out.println();
		System.out.println(">>>" +desc + " sucessfully added to 'To Do' list.");
		System.out.println();
	}
	// Delete item with given ID.
	public void delete(String[] actionsToParse) {
		try {
			int thisID = Integer.parseInt(actionsToParse[1]);
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getId() == thisID) {
					database.remove(i);
					System.out.println();
					System.out.println(">>> 'To Do' item with ID of " + thisID + " successfully removed.");
					System.out.println();
					return;
				} else {
					System.out.println();
					System.out.println("ID " + thisID + " not found! Please use list -a command to confirm ID.");
					System.out.println();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("!!! ERROR: You must provide an ID to delete.");
			System.out.println();
		}
	}
	// Mark item as complete with given ID
	public void markDone(String[] actionsToParse) {
		try {
			int thisID = Integer.parseInt(actionsToParse[1]);		
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getId() == thisID) {
					database.get(i).setCompleted(true);
					System.out.println();
					System.out.println(">>> 'To Do' item with ID of " + thisID + " Marked as done.");
					System.out.println();
					return;
				} else {
					System.out.println();
					System.out.println("ID " + thisID + " not found! Please use list -a command to confirm ID.");
					System.out.println();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("!!! ERROR: You must provide an ID to mark complete.");
			System.out.println();
		}
	}
	// Narrows the list action scope to default (only incomplete), modifier -a (all), or modifier -c (only complete)
	public List<ToDoItem> list(String[] actionsToParse) {
		List<ToDoItem> placeholder = new ArrayList<>();
		if (actionsToParse.length == 1) {
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).isCompleted().equals("NO")) {
					placeholder.add(database.get(i));
				}
			}
		}
		if (actionsToParse.length == 2) {
			if (actionsToParse[1].contains("-a")) {
				placeholder = database;
			}
			if (actionsToParse[1].contains("-c")) {
				for (int i = 0; i < database.size(); i++) {
					if (database.get(i).isCompleted().equals("YES")) {
						placeholder.add(database.get(i));
					}
				}
			}
		}
		return placeholder;
	}
//	a getter that I didn't end up using, but leaving here just in case.
//	public ToDoItem get(int thisID) {
//		ToDoItem searchedByID = new ToDoItem(null);
//		for (int i = 0; i < database.size(); i++){
//			if (database.get(i).getId() == thisID) {
//				searchedByID = database.get(i);
//			} else {
//				searchedByID = null;
//			}
//		}
//		return searchedByID;
//	}
}
