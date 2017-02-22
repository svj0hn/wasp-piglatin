package tests;

import piglatin.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PigLatinConverterTest {
	@Test
	public void testConvertWordConsToPigLatin() {
		String output = PigLatinConverter.convertWordToPigLatin("hello");
		assertEquals(output, "ellohay");
	}

	@Test
	public void testConvertWordVowelToPigLatin() {
		String output = PigLatinConverter.convertWordToPigLatin("aberration");
		assertEquals(output, "aberrationay");
	}
	
	@Test
	public void testIsVowel() {
		assertTrue(PigLatinConverter.isVowel('a') &&
						PigLatinConverter.isVowel('e') &&
						PigLatinConverter.isVowel('i') &&
						PigLatinConverter.isVowel('o') &&
						PigLatinConverter.isVowel('u') &&
						PigLatinConverter.isVowel('y') &&
						!(PigLatinConverter.isVowel('b') ||
						PigLatinConverter.isVowel('k') ||
						PigLatinConverter.isVowel('!') ||
						PigLatinConverter.isVowel('#')));
	}
}