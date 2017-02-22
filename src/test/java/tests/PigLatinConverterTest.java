package tests;

import piglatin.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PigLatinConverterTest {
  @Test
  public void testConvertWordToPigLatin() {
	String output = PigLatinConverter.convertWordToPigLatin("hello");
    assertEquals(output, "ellohay");
  }
}