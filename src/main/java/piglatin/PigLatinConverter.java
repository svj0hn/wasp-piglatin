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

    public static String convertMixedCaseWordToPigLatin(String word) {       
        String output = new String(); 
        

        output = convertWordToPigLatin(word); 
        return output;            
    }
	

    public static List<Boolean> getStringUppercaseProfile(String inputString) {
        List<Boolean> out = new ArrayList<Boolean>();
        for(char c : inputString.toCharArray()) {
            out.add(Character.isUpperCase(c)); 
        }
        return out; 
    }
    
	public static List<String> convertWordFromPigLatin(String word) {		
		List<String> outputs = new ArrayList<String>(); 
		
		// Ensure that the word ends with "ay" and strip it away...
		String ending = word.substring(word.length()-2, word.length());
		if (!ending.equals("ay")) {
			System.out.println(word + " is not a valid pig latin word!");
		}	
		
		// Handle the case when the word ends with "way"
		String remainingWord = word.substring(0, word.length()-2);
		int lastConsonantIndex = remainingWord.length()-1;
		if ((remainingWord.charAt(lastConsonantIndex) == 'w') && isVowel(remainingWord.charAt(0))){			
			outputs.add(remainingWord.substring(0,remainingWord.length()-1));
		}
		
		// Successively, move consonants to the beginning...		
		while(!isVowel(remainingWord.charAt(lastConsonantIndex))) {				
			String candidateWord = remainingWord.substring(lastConsonantIndex, remainingWord.length())+word.substring(0,lastConsonantIndex);				
			outputs.add(candidateWord);
			lastConsonantIndex--;
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
		
		// For each piglatin word in the input string....
		for (String word: words) {
			//... get all the potential non-piglatin candidates....
			List<String> candidates = convertWordFromPigLatin(word);						
			// ... and for each candidate / word option, branch the "tree"
			// which will eventually contain all possible combintations
			// of the all possible candidate words...
			List<String> branchedOutputs = new ArrayList<String>();			
			for (String output : outputs) {
				for (String candidate : candidates) {				
					branchedOutputs.add(output + " " + candidate);	
				}	
			}
			outputs=branchedOutputs;				
		}		
		
		// Finally, trim away the leading whitespaces...
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