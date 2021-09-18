package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestToUTF8 {

	@Test
	void shouldEncodeForLowestSingleByteUTFEight() {
		CodePoint codePoint = new CodePoint("0000");
		assertEquals("00", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointSingleByteUTFEight() {
		CodePoint codePoint = new CodePoint("004e");
		assertEquals("4E", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestSingleByteUTFEight() {
		CodePoint codePoint = new CodePoint("007f");
		assertEquals("7F", codePoint.toUTF8());
	}

	@Test
	void shouldEncodeForLowestTwoByteUTFEight() {
		CodePoint codePoint = new CodePoint("0080");
		assertEquals("C280", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointTwoByteUTFEight() {
		CodePoint codePoint = new CodePoint("01A0");
		assertEquals("C6A0", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestTwoByteUTFEight() {
		CodePoint codePoint = new CodePoint("07FF");
		assertEquals("DFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForLowestThreeByteUTFEight() {
		CodePoint codePoint = new CodePoint("0800");
		assertEquals("E0A080", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointThreeByteUTFEight() {
		CodePoint codePoint = new CodePoint("4ce3");
		assertEquals("E4B3A3", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeForHighestThreeByteUTFEight() {
		CodePoint codePoint = new CodePoint("FFFF");
		assertEquals("EFBFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeLowestFourByteUTFEight() {
		CodePoint codePoint = new CodePoint("10000");
		assertEquals("F0908080", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeMidpointFourByteUTFEight() {
		CodePoint codePoint = new CodePoint("1015EF");
		assertEquals("F48197AF", codePoint.toUTF8());
	}
	
	@Test
	void shouldEncodeHighestFourByteUTFEight() {
		CodePoint codePoint = new CodePoint("10FFFF");
		assertEquals("F48FBFBF", codePoint.toUTF8());
	}
	
	@Test
	void shouldNotEncodeValueOfOneHigherThanMaximum() {
		CodePoint codePoint = new CodePoint("110000");
		assertEquals(null, codePoint.toUTF8());
	}
	
	@Test
	void shouldNotEncodeValueOfWellHigherThanMaximum() {
		CodePoint codePoint = new CodePoint("FFFFFF");
		assertEquals(null, codePoint.toUTF8());
	}
}
