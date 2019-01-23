import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class GradeBook {
	
	// Display a title, call all the helper methods to get the heavy lifting done.
	public static void main(String[] args) {
		System.out.println("STUDENT GRADE BOOK");
		Scanner reader = new Scanner(System.in); // Open reader out here, pass it in to methods as needed.
		Integer noOfStudents = buildList(reader); // Get number of students.
		HashMap<String, String> studentsAndGrades = getInfo(noOfStudents, reader); // Pass number of students, build a HashMap with that many keys.
		HashMap<String, Float> studentsAndAverages = getAvg(studentsAndGrades); // Pass the HashMap of students and grades and modify.
		printResults(studentsAndAverages); // Display the list of names and averages.
		reader.close();
	}

	// Determines how many students will be entered, which determines overall size of the HashMap.
	public static int buildList(Scanner reader) {
		System.out.print("How many students? ");
		Integer studentAmt = reader.nextInt();
		return studentAmt;
	}
	
	// Creates the initial HashMap Keys (student names) and Values (A list of their grades, separated by commas).
	public static HashMap<String, String> getInfo(Integer thisMany, Scanner reader) {
		boolean askForInput = true;
		HashMap<String, String> namesAndGrades = new HashMap<>();
		while (askForInput) {
			System.out.print("Name of student: ");
			String name = reader.next();
			System.out.print("Grades for " + name + ", separated by commas (ex: 100,95,80): ");
			String grades = reader.next();
			namesAndGrades.put(name, grades);
			thisMany = thisMany - 1;
			if (thisMany == 0) {
				askForInput = false;
			}
		}
		return namesAndGrades;
	}
	
	// Takes the HashMap of students and grades, breaks it down, changes the list of grades to a grade average and return.
	public static HashMap<String, Float> getAvg(HashMap<String, String> studentsAndGrades) {
		HashMap<String, Float> namesAndAverages = new HashMap<>();
		ArrayList<String> names = new ArrayList<String>(studentsAndGrades.keySet());		
		ArrayList<String> grades = new ArrayList<String>(studentsAndGrades.values());
		String namePlaceHolder = "";
		String gradesPlaceHolder = "";
		float gradeAvgPlaceHolder = 0;
		for (int i = 0; i < names.size(); i++) {
			namePlaceHolder = names.get(i);
			gradesPlaceHolder = grades.get(i);
			Integer gradesTotal = splitAndtotal(gradesPlaceHolder);
			gradeAvgPlaceHolder = ((float)gradesTotal / (float)gradesPlaceHolder.length());
			namesAndAverages.put(namePlaceHolder, gradeAvgPlaceHolder);
		}
		return namesAndAverages;
	
	}
	
	// Helper method to split the list of grades into an array, add all grades together and return the total.
	public static Integer splitAndtotal(String gradesPlaceHolder) {
		Integer sumOfGrades = 0;
		String[] splitUpValues = gradesPlaceHolder.split(",");
		Integer[] valuesParsed = new Integer[splitUpValues.length];
		for (int i = 0; i < splitUpValues.length; i++) {
			Integer num = Integer.parseInt(splitUpValues[i]);
			valuesParsed[i] = num;
		} 
		for (int i = 0; i < valuesParsed.length; i++) {
			sumOfGrades += valuesParsed[i];
		}
		return sumOfGrades;
	}
	
	// Display the names and grade averages.
	public static void printResults(HashMap<String,Float> studentsAndAverages) {
		ArrayList<String> names = new ArrayList<String>(studentsAndAverages.keySet());		
		ArrayList<Float> gradeAvg = new ArrayList<Float>(studentsAndAverages.values());		
		for (int i = 0; i <  studentsAndAverages.size(); i++) {
			System.out.println("Student: " + names.get(i) + "   " + "Grade Average: " + gradeAvg.get(i));
		}
	}
}
