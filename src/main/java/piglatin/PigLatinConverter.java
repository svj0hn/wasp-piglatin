package piglatin;

import java.util.Scanner;

public class PigLatinConverter {
	
	public static boolean isVowel(char letter) {
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
			return true;
		}
		return false;
	}
	
	public static String getInputFromCommand() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		return input;
	}
	
	public static String convertWordToPigLatin(String word) {		
        String out = new String(); 
		
		int firstVovelIndex = 0;
		while(!isVowel(word.charAt(firstVovelIndex))) {
			firstVovelIndex++;
		}
		
        if(firstVovelIndex==0) {
            out = word + "way";
        } else {
            String leadingConsonants = word.substring(0,firstVovelIndex); 
            String remainingLetters = word.substring(firstVovelIndex, word.length());
            out = remainingLetters + leadingConsonants + "ay"; 
        }

		return out;            
	}
	
	public static void main(String[] args) {
		String input = getInputFromCommand();
		
		String output = convertWordToPigLatin(input);
		
		System.out.println(output);
	}
}