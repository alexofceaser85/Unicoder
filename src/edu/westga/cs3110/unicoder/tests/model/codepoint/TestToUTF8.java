package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF8 {

	@Test
	void shouldEncodeForMinValue() {
		String maxValue = String.format("%x", Integer.MIN_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals("80000000", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForMaxValue() {
		String maxValue = String.format("%x", Integer.MAX_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals(null, codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForLowestSingleByteUTFEight() {
		Codepoint codePoint = new Codepoint("0000");
		assertEquals("00", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointSingleByteUTFEight() {
		Codepoint codePoint = new Codepoint("004e");
		assertEquals("4E", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestSingleByteUTFEight() {
		Codepoint codePoint = new Codepoint("007f");
		assertEquals("7F", codePoint.toUTF8());
	}

	@Test
	void shouldEncodeForLowestTwoByteUTFEight() {
		Codepoint codePoint = new Codepoint("0080");
		assertEquals("C280", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointTwoByteUTFEight() {
		Codepoint codePoint = new Codepoint("01A0");
		assertEquals("C6A0", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTFEight() {
		Codepoint codePoint = new Codepoint("07FF");
		assertEquals("DFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForLowestThreeByteUTFEight() {
		Codepoint codePoint = new Codepoint("0800");
		assertEquals("E0A080", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointThreeByteUTFEight() {
		Codepoint codePoint = new Codepoint("4ce3");
		assertEquals("E4B3A3", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestThreeByteUTFEight() {
		Codepoint codePoint = new Codepoint("FFFF");
		assertEquals("EFBFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeLowestFourByteUTFEight() {
		Codepoint codePoint = new Codepoint("10000");
		assertEquals("F0908080", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointFourByteUTFEight() {
		Codepoint codePoint = new Codepoint("1015EF");
		assertEquals("F48197AF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeHighestFourByteUTFEight() {
		Codepoint codePoint = new Codepoint("10FFFF");
		assertEquals("F48FBFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldNotEncodeValueOfOneHigherThanMaximum() {
		Codepoint codePoint = new Codepoint("110000");
		assertEquals(null, codePoint.toUTF8());
	}
	
	@Test
	void shouldNotEncodeValueOfWellHigherThanMaximum() {
		Codepoint codePoint = new Codepoint("FFFFFF");
		assertEquals(null, codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeLowercaseValue() {
		Codepoint codePoint = new Codepoint("10ffff");
		assertEquals("F48FBFBF", codePoint.toUTF8());
	}
}
