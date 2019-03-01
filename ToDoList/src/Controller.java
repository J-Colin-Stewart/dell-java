import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		DAO newToDoList = new DAO(); // Instantiate a Data Access Object
		boolean helpPrinted = false; // boolean to prevent re-print of main menu when detailed help is printed
		Scanner input = new Scanner(System.in); // Open Scanner here and pass where needed
		System.out.println("TO DO LIST - A HELPFUL TASK TRACKER"); // Title
		appStart(input, newToDoList, helpPrinted); // Start app, hand off the Scanner, DAO and help menu boolean.
		input.close(); // Closes Scanner when app run complete.
	}
	// Main applicatioin run space and loop.
	private static void appStart(Scanner in, DAO toDoList, boolean helpWasPrinted) {
		String menuAction; // Placeholder for user input menu actions.
		boolean continueRun = true; // Program run loop
		while (continueRun) {
			if (!helpWasPrinted) {
				printMenu(); // Only print the main menu if help menu was not just printed.
			}
			helpWasPrinted = false; // Reset the help menu printed boolean for next run.
			System.out.print("What would you like to do? "); // Request user input.
			menuAction = in.nextLine();
			String[] actionParts = menuAction.split(" "); // Split input into parts with space delimiter.
	    String action = actionParts[0].trim(); // Primary action
	    
	    if (action.equals("add")) {
        toDoList.add(in); // Call add method from DAO
	    } else if (action.equals("delete")) {
        toDoList.delete(actionParts); // Call delete method from DAO
	    } else if (action.equals("done")) {
        toDoList.markDone(actionParts); // Call the method to mark complete from DAO
	    } else if (action.equals("list")) {
        printList(toDoList.list(actionParts)); // printLIst is local, list method from DAO determines scope
	    } else if (action.equals("quit")) {
	    	continueRun = false; // Set program run boolean to false to exit app loop
	    } else if (action.equals("help")) {
	    	printHelp(); // Print the verbose help menu
	    	helpWasPrinted = true; // When true, skips the standard menu print
	    } else if(action.length() == 0 ){
    		// do nothing.
	    }
		}		
	}
	// The standard menu, without verbose instructions
	private static void printMenu(){
		System.out.println("-----------------------------------");
    System.out.println("Valid commands: ");
    System.out.println("  list [-c][-a]  Show 'To Do' list entries");
    System.out.println("  add            Add a 'To Do' list entry");
    System.out.println("  done [ID]      Mark a 'To Do' list entry as completed");
    System.out.println("  delete [ID]    Remove an item from the 'To Do' list");
    System.out.println("  help           print help");
    System.out.println("  quit           quit the app");
    System.out.println();
  }
	// Help menu provides additional instruction/clarificaiton
	private static void printHelp(){
		System.out.println("-----------------------------------");
    System.out.println("Commands help: ");
    System.out.println("  >list [-c][-a] Show incomplete 'To Do' list entries. -c to show completed, -a to show all. ");
    System.out.println("  >add           Add a 'To Do' list entry and a description.");
    System.out.println("  >done [ID]     Mark a 'To Do' list entry as completed. Use list to find the ID.");
    System.out.println("  >delete [ID]   Remove an item from the 'To Do' list. use list to find the ID.");
    System.out.println("  >help          print help (this menu)");
    System.out.println("  >quit          quit the app");
    System.out.println();
  }
	// Clean to do list printout (shamelessly stolen from checkpoint project an modified)
	private static void printList(List<ToDoItem> entries){
    int longestItem =  7;
    for(ToDoItem entry : entries){
        if(entry.getDesc().length() > longestItem){
            longestItem = entry.getDesc().length();
        }
    }
    String itemHeader = String.format("%"+longestItem+"s", "Project");
    String itemUnderline = "";
    for(int i=0;i<longestItem;i++){
        itemUnderline+="-";
    }
    System.out.println(" ID | "+itemHeader   +" | Completed? ");
    System.out.println("----+-"+itemUnderline+"-+------------");
    for(ToDoItem entry : entries){
        String currItem = String.format("%-"+longestItem+"s", entry.getDesc());
        String isComplete = entry.isCompleted();
        String line = String.format(" %2s | %s | %s ", entry.getId(), currItem, isComplete);
        System.out.println(line);
    }
    if(entries.size() == 1){
        System.out.println("[1 entry]");
    } else {
        System.out.println("["+entries.size()+" entries]");
    }
    System.out.println();
	}
}
