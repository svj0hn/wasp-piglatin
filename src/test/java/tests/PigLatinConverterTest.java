package tests;

import piglatin.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PigLatinConverterTest {
	@Test
	public void testConvertWordToPigLatinInitialSingleConsonant() {
		String output = PigLatinConverter.convertWordToPigLatin("hello");
		assertEquals(output, "ellohay");
	}
	
	@Test
	public void testConvertWordToPigLatinInitialMultipleConsonants() {
		String output = PigLatinConverter.convertWordToPigLatin("cheers");
		assertEquals(output, "eerschay");
	}

	@Test
	public void testConvertWordToPigLatinInitialSingleVowel() {
		String output = PigLatinConverter.convertWordToPigLatin("aberration");
		assertEquals(output, "aberrationway");
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
		assertEquals(output, "ishfay");
	}
	
	@Test
	public void testConvertStringToPigLatinMultipleWords() {
		String output = PigLatinConverter.convertStringToPigLatin("one fish is not enough");
		assertEquals(output, "oneway ishfay isway otnay enoughway");
	}

	@Test
	public void testConvertStringToPigLatinMultipleWordsAndPunktuation() {
		String output = PigLatinConverter.convertStringToPigLatin("lund is the best!");
		assertEquals(output, "undlay isway ethay estbay");
	}
	
}
