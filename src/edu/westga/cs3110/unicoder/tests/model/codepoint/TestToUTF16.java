package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF16 {

	@Test
	void shouldEncodeForMinValue() {
		String maxValue = String.format("%x", Integer.MIN_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals("80000000", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForMaxValue() {
		String maxValue = String.format("%x", Integer.MAX_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForLowestTwoByteUTF16InFirstGroup() {
		Codepoint codePoint = new Codepoint("0000");
		assertEquals("0000", codePoint.toUTF16());
	}

	@Test
	void shouldEncodeForHighestTwoByteUTF16InFirstGroup() {
		Codepoint codePoint = new Codepoint("D7FF");
		assertEquals("D7FF", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTF16InSecondGroup() {
		Codepoint codePoint = new Codepoint("FFFF");
		assertEquals("FFFF", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForLowestTwoByteUTF16InSecondGroup() {
		Codepoint codePoint = new Codepoint("E000");
		assertEquals("E000", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForLowestTwoByteUTF16() {
		Codepoint codePoint = new Codepoint("10000");
		assertEquals("D800DC00", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForMidpointTwpByteUTF16() {
		Codepoint codePoint = new Codepoint("0183A5");
		assertEquals("D820DFA5", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForSecondMidpointTwoByteUTF16() {
		Codepoint codePoint = new Codepoint("1682F");
		assertEquals("D81ADC2F", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTF16() {
		Codepoint codePoint = new Codepoint("10FFFF");
		assertEquals("DBFFDFFF", codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteOneHigherThanFirstGroup() {
		Codepoint codePoint = new Codepoint("D800");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteWellHigherThanFirstGroup() {
		Codepoint codePoint = new Codepoint("DAC0");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForTwoByteOneLowerThanFirstGroup() {
		Codepoint codePoint = new Codepoint("DFFF");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteWellLowerThanFirstGroup() {
		Codepoint codePoint = new Codepoint("DEA8");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteOneHigherThanSecondGroup() {
		Codepoint codePoint = new Codepoint("10000");
		assertEquals("D800DC00", codePoint.toUTF16());
	}
	
	@Test
	void shouldEncodeForFourByteWellHigherThanSecondGroup() {
		Codepoint codePoint = new Codepoint("15F90");
		assertEquals("D817DF90", codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForFourByteOneHigherThanSecondGroup() {
		Codepoint codePoint = new Codepoint("110000");
		assertEquals(null, codePoint.toUTF16());
	}
	
	@Test
	void shouldNotEncodeForFourByteWellHigherThanSecondGroup() {
		Codepoint codePoint = new Codepoint("204240");
		assertEquals(null, codePoint.toUTF16());
	}
}
