import java.util.Arrays;
import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		System.out.println("STATISTICAL ANALYSIS");
		String valuesIn = getValues();
		int[] arrayOfInts = parseValues(valuesIn);
		int[] sortedArray = sortValues(arrayOfInts);
		performAnalysis(sortedArray);
	}

	public static String getValues() {
		System.out.println("Please provide a list of numbers, separated by commas.");
		System.out.print("(Ex: 1,2,3,4,5): ");
		Scanner reader = new Scanner(System.in);
		String valuesOut = reader.next();
		reader.close();
		return valuesOut;
	}
	
	public static int[] parseValues(String valuesIn) {
		String[] splitUpValues = valuesIn.split(",");
		Integer[] valuesParsed = new Integer[splitUpValues.length];
		for (int i = 0; i < splitUpValues.length; i++) {
			Integer num = Integer.parseInt(splitUpValues[i]);
			valuesParsed[i] = num;
		}
		int[] intArrayOut = Arrays.stream(valuesParsed).mapToInt(Integer::intValue).toArray();
		return intArrayOut;
	}	
	
	public static int[] sortValues(int[] array) {
		Arrays.sort(array);
		System.out.print("Numbers in ascending order: ");
		for (int j = 0; j < array.length; j++) {
			int currentValue = array[j];
			System.out.print(currentValue + " ");
		}
		System.out.println("");
		return array;
	}
	
	public static void performAnalysis(int[] sortedArray) {
		System.out.println("Lowest value: " + sortedArray[0]);
		System.out.println("Highest value: " + sortedArray[sortedArray.length - 1]);
		int arrayTotal = 0;
		for (int i = 0; i < sortedArray.length; i++) {
			arrayTotal += sortedArray[i];
		}
		System.out.println("Amount of numbers provided: " + sortedArray.length);
		System.out.println("Average value: " + ((float)arrayTotal / (float)sortedArray.length));
		System.out.println("Sum of all values: " + arrayTotal);
	}
	
}
