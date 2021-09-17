package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.CodePoint;

class TestConstructor {

	@Test
	public void shouldNotAllowNullCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint(null);
		});
	}
	
	@Test
	public void shouldNotAllowEmptyCodePoint() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterOneAboveUpperCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("11556G");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterOneAboveLowerCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("11556g");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterWellAboveUpperCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("11556Z");
		});
	}
	
	@Test
	public void shouldNotAllowCodePointWithLetterWellAboveLowerCaseF() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CodePoint("11556z");
		});
	}
	
	@Test
	public void shouldAllowCodePointWithMinimumNumberValues() {
		CodePoint codePoint = new CodePoint("000000");
		assertEquals("000000", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMaximumNumberValues() {
		CodePoint codePoint = new CodePoint("999999");
		assertEquals("999999", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMinimumLetterValues() {
		CodePoint codePoint = new CodePoint("aaaaaa");
		assertEquals("aaaaaa", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithMaximumLetterValues() {
		CodePoint codePoint = new CodePoint("ffffff");
		assertEquals("ffffff", codePoint.getCodePoint());
	}

	@Test
	public void shouldAllowCodePointWithMinimumNumberAndLetterValues() {
		CodePoint codePoint = new CodePoint("0a0a0a");
		assertEquals("0a0a0a", codePoint.getCodePoint());
	}

	@Test
	public void shouldAllowCodePointWithMaximumNumberAndLetterValues() {
		CodePoint codePoint = new CodePoint("f9f9f9");
		assertEquals("f9f9f9", codePoint.getCodePoint());
	}
	
	@Test
	public void shouldAllowCodePointWithVariedValues() {
		CodePoint codePoint = new CodePoint("a1f5ce");
		assertEquals("a1f5ce", codePoint.getCodePoint());
	}

}
