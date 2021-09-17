package edu.westga.cs3110.unicoder.model;

/**
 * Gets the code point for given UTF encodings
 * 
 * @author Alex DeCesare
 * @version 17-September-2021
 */

public class CodePoint {
	
	private final String validCodePointRegex = "([a-f]|[A-F]|[0-9])+";
	private String codePoint;
	
	/**
	 * Creates a new code point
	 * 
	 * @precondition codePoint != null && codePoint.isEmpty() == false && codePoint.matches(validCodePointRegex)
	 * @postcondition this.codePoint == codePoint
	 * 
	 * @param codePoint the code point
	 */
	public CodePoint(String codePoint) {
		
		if (codePoint == null) {
			throw new IllegalArgumentException("Cannot allow a null code point");
		}
		if (codePoint.isEmpty()) {
			throw new IllegalArgumentException("Cannot allow an empty code point");
		}
		if (!codePoint.matches(validCodePointRegex)) {
			throw new IllegalArgumentException("Cannot allow a code point that is in the invalid format");
		}
		
		this.codePoint = codePoint;
	}
	
	/**
	 * Gets the code point
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the code point
	 */
	
	public String getCodePoint() {
		return this.codePoint;
	}

}
