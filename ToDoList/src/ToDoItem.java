
public class ToDoItem {

	int id; // ID is set by NextID iteration
	String description; // A descriptive title
	boolean completed; // Completion flag
	
	private static int NEXTID = 1;
	
	public ToDoItem(String desc) {
		id = NEXTID; // Pull the ID from NEXTID before iterating
		description = desc; // Description set by input/instantiation
		completed = false; // Set to not completed as default
		NEXTID++; // Bump the iterator to next ID before next run
	}
	// description getter
	public String getDesc() {
		return description;
	}
	// description setter
	public void setDesc(String description) {
		this.description = description;
	}
	// completion flag getter
	public String isCompleted() {
		String isItDone = "NO";
		if (completed) {
			isItDone = "YES";
		}
		return isItDone;
	}
	// completion flag setter
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	// completion flag getter (no setter necessary, NEXTID iterator is the setter)
	public int getId() {
		return id;
	}
	
}
