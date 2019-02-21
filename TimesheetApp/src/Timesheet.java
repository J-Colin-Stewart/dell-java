import java.util.List;
import java.util.ArrayList;

public class Timesheet {

	private List<TimesheetEntry> database;
	
	Timesheet() {
		database = new ArrayList<>();
	}
	
	public void add(String thisProject, String thisTask) {
		TimesheetEntry newProject = new TimesheetEntry(thisProject, thisTask);
		database.add(newProject);
		System.out.println(thisProject + " project successfully added to project database.");
	}
	
	public void stop(TimesheetEntry entry) {
		entry.updateEndTime();
	}
	
	public void delete(int thisID) {
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId() == thisID) {
				database.remove(i);
				System.out.println("Project entry with ID of " + thisID + " successfully removed from project database.");
				return;
			}
		}
	}
	
	public List<TimesheetEntry> list() {
		List<TimesheetEntry> placeholder = database;
		return placeholder;
	}
	
	public TimesheetEntry get(int thisID) {
		TimesheetEntry searchedByID = new TimesheetEntry(null, null);
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

