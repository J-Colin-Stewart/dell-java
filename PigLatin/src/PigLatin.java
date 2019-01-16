import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		System.out.println("PIG LATIN TRANSLATOR - AMAZE YOUR FRIENDS AND CONVERSE WITH SUIDAE!");
		String wordToTranslate = getWord();
		int transType = determineType(wordToTranslate.toLowerCase());
		translateToPigLatin(wordToTranslate.toLowerCase(), transType);
	}
	
	// Get a word to translate
	public static String getWord() {
		System.out.print("Please provide a word for translation: ");
		Scanner reader = new Scanner(System.in);
		String word = reader.nextLine();
		reader.close();
		return word;
	}
	
	// Determine word type (0 =  no vowels, 1 = starts with vowel, 2 = contains vowel but not at start)
	public static int determineType(String getType) {
		int wordType = 0;
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for (int i = 0; i < vowels.length; i++) {
			if (getType.charAt(0) == vowels[i]) {
				wordType = 1;
				return wordType;
			}			
		}
		for (int j = 1; j < getType.length(); j++) {
			for (int k = 0; k < vowels.length; k++) {
				if (getType.charAt(j) == vowels[k]) {
					wordType = 2;
					return wordType;
				}
			}			
		}
		return wordType;
	}
	
	// Displays translated word (capitalization is dropped)
	public static void translateToPigLatin(String thisWord, int thisType) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		if (thisType == 1) {
			System.out.println(thisWord + " translated to pig latin is " + thisWord + "yay");
		}
		else if (thisType == 2) {
			for (int i = 1; i < thisWord.length(); i++) {
				for (int j = 0; j < vowels.length; j++) {
					if (thisWord.charAt(i) == vowels[j]) {
						String beforeVowels = thisWord.substring(0,  i);
						String afterVowels = thisWord.substring(i, thisWord.length());
						System.out.println(thisWord + " translated to pig latin is " + afterVowels + beforeVowels + "ay");
						return;
					}
				}
			}
		}
		else {
			System.out.println(thisWord + " translated to pig latin is " + thisWord + "ay");
		}
	}
}
