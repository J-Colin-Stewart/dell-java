import java.time.LocalDate;

public class LicenseProgram {

	public static void main(String[] args) {
		System.out.println("'OFFICIAL' DRIVERS LICENSE RECORDS");
		System.out.println("__________________________________");
		DriversLicense license1 = new DriversLicense();
		DriversLicense license2 = new DriversLicense();
		DriversLicense license3 = new DriversLicense();
		
		license1.firstName = "Walter";
		license1.lastName = "White";
		license1.DOB = LocalDate.of(1958, 9, 7); // According to the wiki.
		license1.height = 71; // Also according to the wiki.
		license1.gender = 'M';
		
		license2.firstName = "Anastasia";
		license2.lastName = "'The Baroness' Cisarovna";
		license2.DOB = LocalDate.of(1982, 6, 13); // GI Joe #1 was published in June 1982. Seems appropriate.
		license2.height = 65; // 5'5" as portrayed by Sienna Miller. Plus the "I'm a baddie" stiletto heels.
		license2.gender = 'F';
		
		license3.firstName = "Smaug";
		license3.lastName = "the Terrible";
		license3.DOB = LocalDate.of(-1379, 9, 3); // One ring to rule them all, etc. There's a nerd joke in here.
		license3.height = 387; // Shot in the dark guess. Wiki only says how long he was, but probably this tall on all fours.
		license3.gender = 'M'; // Kudos if you're actually reading all this lol.
		
		System.out.println("First entry:");
		System.out.println("------------");
		System.out.println("Full name: " + license1.getFullName());
		System.out.println("Age: " + license1.getAge());
		System.out.println("Height: " + license1.feetInches());
		System.out.println("Gender: " + license1.genderLong());
		System.out.println("");
		System.out.println("Second entry:");
		System.out.println("------------");
		System.out.println("Full name: " + license2.getFullName());
		System.out.println("Age: " + license2.getAge());
		System.out.println("Height: " + license2.feetInches());
		System.out.println("Gender: " + license2.genderLong());
		System.out.println("");
		System.out.println("Third entry:");
		System.out.println("------------");
		System.out.println("Full name: " + license3.getFullName());
		System.out.println("Age: " + license3.getAge());
		System.out.println("Height: " + license3.feetInches());
		System.out.println("Gender: " + license3.genderLong());

	}

}
