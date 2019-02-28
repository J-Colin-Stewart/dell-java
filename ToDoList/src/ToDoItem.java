
public class ToDoItem {

	int id;
	String description;
	boolean completed;
	
	private static int NEXTID = 1;
	
	public ToDoItem(String desc) {
		id = NEXTID;
		description = desc;
		completed = false;
		NEXTID++;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public String isCompleted() {
		String isItDone = "NO";
		if (completed) {
			isItDone = "YES";
		}
		return isItDone;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getId() {
		return id;
	}
	
}
