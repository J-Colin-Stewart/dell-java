import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

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
		int studentAmt = 0;
		while (studentAmt <= 0) {
			try {
				System.out.print("How many students? ");
				studentAmt = reader.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("Invalid entry - please enter a number.");
					reader.nextLine();
				}
			}				
		return studentAmt;
	}
	
	// Creates the initial HashMap Keys (student names) and Values (A list of their grades, separated by commas).
	public static HashMap<String, String> getInfo(Integer thisMany, Scanner reader) {
		HashMap<String, String> namesAndGrades = new HashMap<>();
		for (int i = 0; i < thisMany; i++) {
			String grades = "";
			System.out.print("Name of student #" + (i+1) +" : ");
			reader.nextLine();
			String name = reader.nextLine();
			boolean validEntries = false;
			while (!validEntries) {
				System.out.print("Grades for " + name + ", separated by commas (ex: 100,95,80): ");
				grades = reader.nextLine();
				validEntries = validateGradeEntry(grades);
			}
			namesAndGrades.put(name, grades);
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
			float avgDivisor = getAvgDivisor(gradesPlaceHolder);
			Integer gradesTotal = splitAndtotal(gradesPlaceHolder);
			gradeAvgPlaceHolder = ((float)gradesTotal / avgDivisor);
			namesAndAverages.put(namePlaceHolder, gradeAvgPlaceHolder);
		}
		return namesAndAverages;
	
	}
	
	// Split the list of grades into an array, add all grades together and return the total.
	public static Integer splitAndtotal(String gradesPlaceHolder) {
		Integer sumOfGrades = 0;
		String[] splitUpValues = gradesPlaceHolder.split(",");
		Integer[] valuesParsed = new Integer[splitUpValues.length];
		for (int i = 0; i < splitUpValues.length; i++) {
			Integer num = Integer.parseInt(splitUpValues[i]);
			valuesParsed[i] = num;
		}
		int[] intArrayOut = Arrays.stream(valuesParsed).mapToInt(Integer::intValue).toArray();		
		for (int i = 0; i < intArrayOut.length; i++) {
			sumOfGrades += intArrayOut[i];
		}
		return sumOfGrades;
	}
	
	// Gives the divisor for the grade averaging operation in getAvg().
	public static float getAvgDivisor(String gradesPlaceHolder) {
		String[] splitUpValues = gradesPlaceHolder.split(",");
		float divideByThis = splitUpValues.length;
		return divideByThis;
	}
	
	// Makes sure the grade entries are all integers between 0 and 100
	public static boolean validateGradeEntry(String grades) {
		boolean gradesAreValid = true;
		String[] splitUpValues = grades.split(",");
		for (int i = 0; i < splitUpValues.length; i++) {
			try {
				Integer num = Integer.parseInt(splitUpValues[i]);
				if ((!(num >= 0)) || (!(num <= 110))) {
					System.out.println("One of your grade entries is out of normal grade range. Try again.");
					gradesAreValid = false;
					break;				
				}
			} catch(NumberFormatException e) {
				System.out.println("One of your grade entries is not a number or you used a space. Try again.");
				gradesAreValid = false;
				break;
			} 
				
		}
		return gradesAreValid;
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
