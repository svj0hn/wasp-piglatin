package tests;

import piglatin.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PigLatinConverterTest {
	@Test
	public void testInitialSingleConsonant() {
		String output = PigLatinConverter.convertWordToPigLatin("hello");
		assertEquals(output, "ellohay");
	}
	
	@Test
	public void testInitialMultipleConsonants() {
		String output = PigLatinConverter.convertWordToPigLatin("cheers");
		assertEquals(output, "eerschay");
	}

	@Test
	public void testInitialSingleVovel() {
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
}