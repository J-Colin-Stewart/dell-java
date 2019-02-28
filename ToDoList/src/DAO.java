import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAO {
	
	private static List<ToDoItem> database;

	DAO() {
		database = new ArrayList<>();
	}
	
	public void add(Scanner addThis) {
		System.out.print("Task description: ");
		String desc = addThis.nextLine();
		ToDoItem newItem = new ToDoItem(desc);
		database.add(newItem);
		System.out.println();
		System.out.println(">>>" +desc + " sucessfully added to 'To Do' list.");
		System.out.println();
	}
	
	public void delete(String[] actionsToParse) {
		int thisID = Integer.parseInt(actionsToParse[1]);
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId() == thisID) {
				database.remove(i);
				System.out.println();
				System.out.println(">>> 'To Do' item with ID of " + thisID + " successfully removed.");
				System.out.println();
				return;
			}
		}
	}
	
	public void markDone(String[] actionsToParse) {
		int thisID = Integer.parseInt(actionsToParse[1]);		
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId() == thisID) {
				database.get(i).setCompleted(true);
				System.out.println();
				System.out.println(">>> 'To Do' item with ID of " + thisID + " Marked as done.");
				System.out.println();
				return;
			}
		}
	}
	
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
	
	public ToDoItem get(int thisID) {
		ToDoItem searchedByID = new ToDoItem(null);
		for (int i = 0; i < database.size(); i++){
			if (database.get(i).getId() == thisID) {
				searchedByID = database.get(i);
			} else {
				searchedByID = null;
			}
		}
		return searchedByID;
	}
}
