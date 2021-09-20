package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestConstructor {

	@Test
	public void shouldNotAllowNullCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint(null);
		});
	}
	
	@Test
	public void shouldNotAllowEmptyCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterOneAboveUpperCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("11556G");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterOneAboveLowerCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("11556g");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterWellAboveUpperCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("11556Z");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterWellAboveLowerCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("11556z");
		});
	}
	
	@Test
	public void shouldAllowCodePointWithMinimumNumberValues() {
		Codepoint codePoint = new Codepoint("000000");
		assertEquals("000000", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMaximumNumberValues() {
		Codepoint codePoint = new Codepoint("999999");
		assertEquals("999999", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMinimumLetterValues() {
		Codepoint codePoint = new Codepoint("aaaaaa");
		assertEquals("aaaaaa", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMaximumLetterValues() {
		Codepoint codePoint = new Codepoint("ffffff");
		assertEquals("ffffff", codePoint.getCodePoint());
	}

	@Test
	public void shouldAllowCodePointWithMinimumNumberAndLetterValues() {
		Codepoint codePoint = new Codepoint("0a0a0a");
		assertEquals("0a0a0a", codePoint.getCodePoint());
	}

	@Test
	public void shouldAllowCodePointWithMaximumNumberAndLetterValues() {
		Codepoint codePoint = new Codepoint("f9f9f9");
		assertEquals("f9f9f9", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithVariedValues() {
		Codepoint codePoint = new Codepoint("a1f5ce");
		assertEquals("a1f5ce", codePoint.getCodePoint());
	}

}
