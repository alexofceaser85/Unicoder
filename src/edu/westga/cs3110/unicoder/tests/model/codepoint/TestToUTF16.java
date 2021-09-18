package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestToUTF16 {

	@Test
	void shouldEncodeForLowestTwoByteUTF16InFirstGroup() {
		CodePoint codePoint = new CodePoint("0000");
		assertEquals("0000", codePoint.toUTF16());
	}

	@Test
	void shouldEncodeForHighestTwoByteUTF16InFirstGroup() {
		CodePoint codePoint = new CodePoint("D7FF");
		assertEquals("D7FF", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTF16InSecondGroup() {
		CodePoint codePoint = new CodePoint("FFFF");
		assertEquals("FFFF", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForLowestTwoByteUTF16InSecondGroup() {
		CodePoint codePoint = new CodePoint("E000");
		assertEquals("E000", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForLowestTwoByteUTF16() {
		CodePoint codePoint = new CodePoint("10000");
		assertEquals("D800DC00", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForMidpointTwpByteUTF16() {
		CodePoint codePoint = new CodePoint("0183A5");
		assertEquals("D820DFA5", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForSecondMidpointTwoByteUTF16() {
		CodePoint codePoint = new CodePoint("1682F");
		assertEquals("D81ADC2F", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTF16() {
		CodePoint codePoint = new CodePoint("10FFFF");
		assertEquals("DBFFDFFF", codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteOneHigherThanFirstGroup() {
		CodePoint codePoint = new CodePoint("D800");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteWellHigherThanFirstGroup() {
		CodePoint codePoint = new CodePoint("DAC0");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteOneLowerThanFirstGroup() {
		CodePoint codePoint = new CodePoint("DFFF");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteWellLowerThanFirstGroup() {
		CodePoint codePoint = new CodePoint("DEA8");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteOneHigherThanSecondGroup() {
		CodePoint codePoint = new CodePoint("10000");
		assertEquals("D800DC00", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteWellHigherThanSecondGroup() {
		CodePoint codePoint = new CodePoint("15F90");
		assertEquals("D817DF90", codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForFourByteOneHigherThanSecondGroup() {
		CodePoint codePoint = new CodePoint("110000");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForFourByteWellHigherThanSecondGroup() {
		CodePoint codePoint = new CodePoint("204240");
		assertEquals(null, codePoint.toUTF16());
	}
}
