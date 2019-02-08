import java.util.List;

public class Controller {

	/* Member variables */
	
    Timesheet timesheet;
    ConsoleUtils consoleUtils;
    
    /* Constructor */
    
    public Controller(){
        this.timesheet = new Timesheet();
        this.consoleUtils = new ConsoleUtils();
    }
    
    /* Methods */

	/*
	 * Runs the program
	 */
    public void start() {

        consoleUtils.printHelp(); // Print the action menu

        boolean quit = false;
        while(!quit) {

			// Prompt the user for input, collect input, parse into parts
            String input = consoleUtils.promptString("> ");
            String[] actionParts = input.split(" ");
            String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
            if (action.equals("add")) {

                processAddAction();

            } else if (action.equals("delete")) {

                processDeleteAction(actionParts);

            } else if (action.equals("stop")) {

                processStopAction(actionParts);

            } else if (action.equals("list")) {

                processListAction(actionParts);

            } else if (action.equals("quit")) {

                // Your code here
            	quit = true;

            } else if (action.equals("help")) {

            	// Your code here
            	consoleUtils.printHelp();

            } else if(action.length() ==0 ){
            
                // do nothing.
                
            } else {
            
                // Your code here
                
            }
        }

    }

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as complete)
	 * This method conveys that request to the Timesheet
	 */
    public void processStopAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to stop command");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);

		// Your code here
        TimesheetEntry toStop = timesheet.get(id);
        if (toStop == null) {
        	System.out.println("Project ID not found. Please re-check project ID (use list command).");
        } else {
        	timesheet.stop(toStop);
        }
    }

	/*
	 * The user requested that a given TimesheetEntry be deleted
	 * This method conveys that request to the Timesheet
	 */
    public void processDeleteAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to delete command");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
		
		// Your code here
        TimesheetEntry toDelete = timesheet.get(id);
        if (toDelete == null) {
        	System.out.println("Project ID not found. No projects deleted.");
        } else {
        	timesheet.delete(id);
        }
    }

	/*
	 * The user wants to view a list of timesheet entries
	 * This method conveys that request to the Timesheet,
	 * along with any special options (active-only, filter by project name)
	 */
    public void processListAction(String[] actionParts){
    
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }

		// Your code here
        System.out.println("Current projects in database:");
        List<TimesheetEntry> listOfProjects = timesheet.list();
        consoleUtils.printList(listOfProjects);
    }

	/*
	 * The user wants to add a new entry to the Timesheet
	 * This method conveys that request to the Timesheet, along with
	 * the specified project name and task description 
	 */
    public void processAddAction(){
    
        String project = consoleUtils.promptString("Project Name (one word only):");
        String description = consoleUtils.promptString("Task:");

		// Your code here
        timesheet.add(project, description);
    }
}