package tests;

import piglatin.*;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PigLatinConverterTest {
 	@Test
	public void testConvertWordToPigLatinInitialSingleConsonant() {
		String output = PigLatinConverter.convertWordToPigLatin("hello");
		assertEquals("ellohay", output);
	}
	
	@Test
	public void testConvertWordToPigLatinInitialMultipleConsonants() {
		String output = PigLatinConverter.convertWordToPigLatin("cheers");
		assertEquals("eerschay", output);
	}
	
	@Test
	public void testConvertWordToPigLatinOnlyConsonants() {
		String output = PigLatinConverter.convertWordToPigLatin("rtfm");
		assertEquals("rtfmay", output);
	}
	
	@Test
	public void testConvertWordToPigLatinInitialSingleVowel() {
		String output = PigLatinConverter.convertWordToPigLatin("aberration");
		assertEquals("aberrationway", output);
	} 
	
	@Test
	public void testConvertWordFromPigLatinInitialSingleConsonant() {
		List<String> output = PigLatinConverter.convertWordFromPigLatin("ellohay");
		List<String> expected = Arrays.asList("hello");
		assertEquals(expected, output);
	}		
 
	@Test
	public void testConvertWordFromPigLatinInitialMultipleConsonants() {
		List<String> output = PigLatinConverter.convertWordFromPigLatin("eerschay");		
		List<String> expected = Arrays.asList("heersc","cheers","scheer","rschee");
		assertEquals(expected, output);
	}

	@Test
	public void testConvertWordFromPigLatinInitialSingleVowel() {
		List<String> output = PigLatinConverter.convertWordFromPigLatin("aberrationway");		
		List<String> expected = Arrays.asList("aberration","waberration","nwaberratio");
		assertEquals(expected, output);
	}


	@Test
	public void testConvertWordFromPigLatinInitialSingleVowelMultipleConsonants() {
		List<String> output = PigLatinConverter.convertWordFromPigLatin("arway");		
		List<String> expected = Arrays.asList("ar","war","rwa");
		assertEquals(expected, output);
	}
	
	@Test
	public void testIsVowel() {
		assertTrue(PigLatinConverter.isVowel('a'));
		assertTrue(PigLatinConverter.isVowel('e'));
		assertTrue(PigLatinConverter.isVowel('i'));
		assertTrue(PigLatinConverter.isVowel('o'));
		assertTrue(PigLatinConverter.isVowel('u'));
		assertTrue(PigLatinConverter.isVowel('y'));
		assertFalse(PigLatinConverter.isVowel('b'));
		assertFalse(PigLatinConverter.isVowel('k'));
		assertFalse(PigLatinConverter.isVowel('!'));
		assertFalse(PigLatinConverter.isVowel('#'));
	}
	
	@Test
	public void testConvertStringToPigLatinSingleWord() {
		String output = PigLatinConverter.convertStringToPigLatin("fish");
		assertEquals("ishfay", output);
	}
	
	@Test
	public void testConvertStringToPigLatinMultipleWords() {
		String output = PigLatinConverter.convertStringToPigLatin("one fish is not enough");
		assertEquals("oneway ishfay isway otnay enoughway", output);
	}
	 
	@Test
	public void testConvertStringFromPigLatinSingleWord() {
		List<String> output = PigLatinConverter.convertStringFromPigLatin("ishfay");		
		List<String> expected = Arrays.asList("fish","hfis","shfi");
		assertEquals(expected, output);
	}
  
	@Test
	public void testConvertStringToPigLatinInterpunctuation1() {
		String output = PigLatinConverter.convertStringToPigLatin("north, west, east, and south!");
		assertEquals(output, "orthnay, estway, eastway, andway outhsay!");
	}
	@Test
	public void testConvertStringToPigLatinInterpunctuation2() {
		String output = PigLatinConverter.convertStringToPigLatin("hello, you imbecile");
		assertEquals(output, "ellohay, youway imbecileway");
	}

	@Test
	public void testConvertStringToPigLatinInterpunctuation3() {
		String output = PigLatinConverter.convertStringToPigLatin("you must construct additional pylons...");
		assertEquals(output, "youway ustmay onstructcay additionalway ylonspay...");
	}
		
	@Test
	public void testConvertStringFromPigLatinTwoWords() {
		List<String> output = PigLatinConverter.convertStringFromPigLatin("oneway ishfay");		
		List<String> expected = Arrays.asList("one fish","one hfis","one shfi","wone fish","wone hfis","wone shfi");		
		assertEquals(expected, output);
	}
  
	@Test
	public void testGetInputFromCommand() {
		String input = "some#anNoYING%%str!ng";
		InputStream stdin = System.in;
		
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in); // Spoof user input
		String output = PigLatinConverter.getInputFromCommand();
		System.setIn(stdin);
		
		assertEquals(output, input);
	} 
	
}