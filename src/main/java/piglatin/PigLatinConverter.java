package piglatin;

import java.util.Scanner;

public class PigLatinConverter {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
	
	public static boolean isVowel(char letter) {
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
			return true;
		}
		return false;
	}
	
	public static String getInputFromCommand() {
		Scanner scan = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "Please enter a word/sentence:" + ANSI_RESET);
		String input = scan.next();
		
		return input;
	}
	
	
	public static String convertWordToPigLatin(String word) {		
        String output = new String(); 
		
		int firstVowelIndex = 0;
		while(!isVowel(word.charAt(firstVowelIndex))) {
			firstVowelIndex++;
		}
		
        if(firstVowelIndex==0) {
            output = word + "way";
        } else {
            String leadingConsonants = word.substring(0,firstVowelIndex); 
            String remainingLetters = word.substring(firstVowelIndex, word.length());
            output = remainingLetters + leadingConsonants + "ay"; 
        }

		return output;            
	}
	
	
	public static String convertStringToPigLatin(String inputString) {	
		String[] words = inputString.split(" ");
		String output = new String();
		for (String word: words) {
			output += convertWordToPigLatin(word) + " ";			
		}
		
		return output.substring(0, output.length()-1);
	}
	
	
	public static void main(String[] args) {
		String input = getInputFromCommand();
		String output = convertStringToPigLatin(input);
        System.out.println(ANSI_RESET + "The translation of '" + ANSI_RED  + input + ANSI_RESET + "' is:");
		System.out.println(ANSI_BLUE + output + ANSI_RESET);
	}
}
