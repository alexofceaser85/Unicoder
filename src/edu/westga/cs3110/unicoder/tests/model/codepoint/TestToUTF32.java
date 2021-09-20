package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF32 {

	@Test
	void shouldEncodeLowestValue() {
		String maxValue = String.format("%x", Integer.MIN_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals("80000000", codePoint.toUTF32());
	}
	
	@Test
	void shouldEncodeZero() {
		Codepoint codePoint = new Codepoint("0");
		assertEquals("00000000", codePoint.toUTF32());
	}
	
	@Test
	void shouldEncodeOne() {
		Codepoint codePoint = new Codepoint("1");
		assertEquals("00000001", codePoint.toUTF32());
	}
	
	@Test
	void shouldEncodeHexWellGreaterThanOne() {
		Codepoint codePoint = new Codepoint("3B82");
		assertEquals("00003B82", codePoint.toUTF32());
	}
	
	@Test
	void shouldEncodeHighestValue() {
		String maxValue = String.format("%x", Integer.MAX_VALUE);
		Codepoint codePoint = new Codepoint(maxValue);
		assertEquals("7FFFFFFF", codePoint.toUTF32());
	}
}
