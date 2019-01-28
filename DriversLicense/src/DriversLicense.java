import java.time.*;

public class DriversLicense {
	
	LocalDate today = LocalDate.now(); // made sense to make this a class variable.
	
	public String firstName;
	public String lastName;
	public LocalDate DOB;
	public int height;
	public char gender;

	public DriversLicense() {}	
	
	// Takes height in inches, returns a string giving height in feet and inches.
	public String feetInches() {
		String friendlyHeight = "";
		friendlyHeight = (this.height/12 + " feet " + this.height%12 + " inches");
		return friendlyHeight;
	}
	
	// Calculates the age as the period between the given DOB and today's date (LocalDate today).
	public int getAge() {
		Period period = Period.between(this.DOB, today);
		int age = period.getYears();
		return age;
	}
	
	// Concatenates the first name string and last name string and returns them as one string.
	public String getFullName() {
		String fullName = (this.firstName + " " + this.lastName);
		return fullName;
	}
	
	// Returns gender as full word instead of char.
	public String genderLong() {
		String longGender = "";
		if (this.gender == 'M'){
			longGender = "Male";
		} else if (this.gender == 'F') {
			longGender = "Female";
		}
		return longGender;
	}

}
