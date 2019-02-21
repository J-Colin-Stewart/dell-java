import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// Explain what we will be doing..
		System.out.println("I can perform calculations!");
		System.out.println("Add, subtract, multiply and divide.");
		System.out.print("Please provide a number: ");
		// Get first value.
		Scanner reader = new Scanner(System.in);
		int valueOne = reader.nextInt();
		System.out.print("Now, another number: ");
		// Get second value.
		int valueTwo = reader.nextInt();
		reader.close();
		System.out.println("Great! Let's do some math.");
		// Run the calculation methods.
		add(valueOne, valueTwo);
		subtract(valueOne, valueTwo);
		multiply(valueOne, valueTwo);
		divide(valueOne, valueTwo);
		reader.close();
		
	}
	
	// Outputs the sum of the provided values.
	public static void add(int valueOne, int valueTwo) {
		int added = valueOne + valueTwo;
		System.out.println(valueOne + " + " + valueTwo + " = " + added);
	}
	
	// Outputs the difference of the provided values.
	public static void subtract(int valueOne, int valueTwo) {
		int subtracted = valueOne - valueTwo;
		System.out.println(valueOne + " - " + valueTwo + " = " + subtracted);
	}
	
	// Outputs the product of the provided values.
	public static void multiply(int valueOne, int valueTwo) {
		// Used long instead of int as multiplied values tend to be larger.
		long multiplied = valueOne * valueTwo;
		System.out.println(valueOne + " x " + valueTwo + " = " + multiplied);
	}
	
	// Outputs the quotient of the provided values.
	public static void divide(int valueOne, int valueTwo) {
		// input int values are converted to double so the calculated value is not rounded.
		float divided = (float)valueOne / (float)valueTwo;
		System.out.println(valueOne + " / " + valueTwo + " = " + divided);
	}
}
