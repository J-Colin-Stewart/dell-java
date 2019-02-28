import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		DAO newToDoList = new DAO();
		boolean helpPrinted = false;
		Scanner input = new Scanner(System.in);
		System.out.println("TO DO LIST - A HELPFUL TASK TRACKER");
		appStart(input, newToDoList, helpPrinted);		
		input.close();
	}
	
	private static void appStart(Scanner in, DAO toDoList, boolean helpWasPrinted) {
		String menuAction;
		boolean continueRun = true;
		while (continueRun) {
			if (!helpWasPrinted) {
				printMenu();
			}
			helpWasPrinted = false;
			System.out.print("What would you like to do? ");
			menuAction = in.nextLine();
			String[] actionParts = menuAction.split(" ");
	    String action = actionParts[0].trim(); // Primary action
	    
	    if (action.equals("add")) {
        toDoList.add(in);
	    } else if (action.equals("delete")) {
        toDoList.delete(actionParts);
	    } else if (action.equals("done")) {
        toDoList.markDone(actionParts);
	    } else if (action.equals("list")) {
        printList(toDoList.list(actionParts));
	    } else if (action.equals("quit")) {
	    	continueRun = false;
	    } else if (action.equals("help")) {
	    	printHelp();
	    	helpWasPrinted = true;
	    } else if(action.length() == 0 ){
    		// do nothing.
	    }
		}		
	}
	
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
