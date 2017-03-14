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
		String input = scan.nextLine();
		
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
        inputString = inputString.trim(); 
        String[] words = inputString.split("\\W+");
        String[] delimiters = inputString.split("\\w+");
		String output = new String();
        // The following line does not wor´k
        //output += delimiters[0]; 
        int i = 1;
        String delimiter; 
        int finalDelimiterIndex = 0; 
		for (String word: words) {
            if(i < delimiters.length){ // Usually we use a delimiter
                delimiter = delimiters[i];
            } else {
                delimiter = " "; 
                finalDelimiterIndex = 1; 

            }
            if(word.length()>0) {
                output += convertWordToPigLatin(word);
            }
            output += delimiter; 
            i++; 			
		}
		
		return output.substring(0, output.length()-finalDelimiterIndex);
	}
	
	
	public static void main(String[] args) {
		String input = getInputFromCommand();
		
		String output = convertStringToPigLatin(input);
		
		System.out.println(output);
	}
}