package piglatin;

import java.util.*;

public class PigLatinConverter {
	
	public static boolean isVowel(char letter) {
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
			return true;
		}
		return false;
	}
	
	public static String getInputFromCommand() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		try {
			input = scan.nextLine();
		} catch (java.util.NoSuchElementException e) {
			System.out.println("NoSuchElementException occured while scanning input!");
		} catch (java.lang.IllegalStateException e) {
			System.out.println("IllegalStateException occured while scanning input!");
		}
		
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
	
	public static List<String> convertWordFromPigLatin(String word) {		
        List<String> outputs = new ArrayList<String>(); 
		if (word.substring(word.length()-3, word.length()).equals("way")){			
			outputs.add(word.substring(0, word.length()-3));
			outputs.add("w" + word.substring(0, word.length()-3));
		} else if (word.substring(word.length()-2, word.length()).equals("ay")){			
			int lastConsonantIndex = word.length()-3;
			while(!isVowel(word.charAt(lastConsonantIndex))) {				
				String candidateWord = word.substring(lastConsonantIndex, word.length()-2)+word.substring(0,lastConsonantIndex);				
				outputs.add(candidateWord);
				lastConsonantIndex--;
			}			
		} else {
			throw new IllegalArgumentException(word + " is not a valid pig latin word!");
		}	

		return outputs;            
	}
	
	
	public static String convertStringToPigLatin(String inputString) {	
        inputString = inputString.trim(); 
        String[] words = inputString.split("\\W+");
        String[] delimiters = inputString.split("\\w+");
		String output = new String();
        int i = 1;
		for (String word: words) {
            if(word.length()>0) {
                output += convertWordToPigLatin(word);
            }
            if(i < delimiters.length){ 
                // Usually we use a delimiter, but if some were missed, ignore!
                output += delimiters[i];
            }
            i++; 			
		}
		
		return output.trim();
	}
	
	public static List<String> convertStringFromPigLatin(String inputString) {	
		String[] words = inputString.split(" ");		
		List<String> outputs = new ArrayList<String>();		
		outputs.add("");
		
		for (String word: words) {
			List<String> candidates = convertWordFromPigLatin(word);						
			// For each candidate option, branch the "tree"...
			List<String> branchedOutputs = new ArrayList<String>();			
			for (String output : outputs) {
				for (String candidate : candidates) {				
					branchedOutputs.add(output + " " + candidate);	
				}	
			}
			outputs=branchedOutputs;				
		}		
		
		// Finally, trim away the leading whitespaces.
		List<String> trimmedOutputs = new ArrayList<String>();		
		for (String output : outputs) {
			trimmedOutputs.add(output.trim());
		}
		
		return trimmedOutputs;
	}
	
	public static void main(String[] args) {
		String input = getInputFromCommand();		
		String output = convertStringToPigLatin(input);		
		System.out.println(output);
	}
}