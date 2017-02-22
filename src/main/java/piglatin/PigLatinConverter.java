package piglatin;

import java.util.Scanner;

public class PigLatinConverter {
	
	public static String getInputFromCommand() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		return input;
	}
	
	public static String convertWordToPigLatin(String word) {
		//char[] wordArray = word.toCharArray();
        //char[] outputArray = new char[wordArray.length+1]; 
        //int indexOfLastChar = wordArray.length - 1;
        String out = new String(); 
        if isVowel(word.charAt(0)) {
            out = word + "ay";
        } else {
            String firstChar = word.substring(0,1); 
            String remaining = word.substring(1, word.length());
            out = remaining + firstChar + "ay"; 
        }

        


		return "out";
            }
	}
	
	public static void main(String[] args) {
		String input = getInputFromCommand();
		
		String output = convertWordToPigLatin(input);
		
		System.out.println(output);
	}
}