package converter;

import java.util.Scanner;

public class PigLatinConverter {
	
	public static String getInputFromCommand() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		
		return input;
	}
	
	public static String convertWordToPigLatin(String word) {
		return "Ellohay";
	}
	
	public static void main(String[] args) {
		String input = getInputFromCommand();
		
		String output = convertWordToPigLatin(input);
		
		System.out.println(output);
	}
}