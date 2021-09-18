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
	
	/**
	 * Converts the code point to a UTF-8 representation
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The UTF-8 version of the code point
	 */
	public String toUTF8() {
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, 16);
		
		if (parsedInteger <= 127) {
			return String.format("%02X", parsedInteger);
		} else if (parsedInteger <= 2047) {
			int firstByte = parsedInteger & 0b0000011111000000;
			int secondByte = parsedInteger & 0b0000000000111111;
			
			firstByte = 0b0011000000000000 | firstByte;
			secondByte = 0b0000000010000000 | secondByte;
			
			firstByte = firstByte << 2;
			
			int result = firstByte | secondByte;
			return String.format("%04X", result);
		} else if (parsedInteger <= 65535) {
			int firstByte = parsedInteger  & 0b000000001111000000000000;
			int secondByte = parsedInteger & 0b000000000000111111000000;
			int thirdByte = parsedInteger  & 0b000000000000000000111111;

			firstByte =  0b000011100000000000000000 | firstByte;
			secondByte = 0b000000000010000000000000 | secondByte;
			thirdByte =  0b000000000000000010000000 | thirdByte;
			
			firstByte = firstByte << 4;
			secondByte = secondByte << 2;
			
			int result = 0b000000000000000000000000;
			result = result | firstByte | secondByte | thirdByte;
			return String.format("%06X", result);
		} else if (parsedInteger <= 1114111) {
			int firstByte = parsedInteger  & 0b00000000000111000000000000000000;
			int secondByte = parsedInteger & 0b00000000000000111111000000000000;
			int thirdByte = parsedInteger  & 0b00000000000000000000111111000000;
			int fourthByte = parsedInteger & 0b00000000000000000000000000111111;
			
			firstByte = 0b00000011110000000000000000000000 | firstByte;
			secondByte = 0b00000000000010000000000000000000 | secondByte;
			thirdByte = 0b00000000000000000010000000000000 | thirdByte;
			fourthByte = 0b00000000000000000000000010000000 | fourthByte;
			
			firstByte = firstByte << 6;
			secondByte = secondByte << 4;
			thirdByte = thirdByte << 2;
			
			int result = 0b00000000000000000000000000000000;
			result = result | firstByte | secondByte | thirdByte | fourthByte;
			return String.format("%08X", result);
		} else {
			return null;
		}
	}
	
	/**
	 * Converts the code point to a UTF-16 representation
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The UTF-16 version of the code point
	 */
	
	public String toUTF16() {
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, 16);
		
		if (parsedInteger <= 55295 || (parsedInteger >= 57344 && parsedInteger <= 65535)) {
			return String.format("%04X", parsedInteger);
		} else if (parsedInteger >= 65536 && parsedInteger <= 1114111) {

			parsedInteger = parsedInteger - 0x10000;
			
			int upperBits = 0b00000000000011111111110000000000 & parsedInteger;
			int lowerBits = 0b00000000000000000000001111111111 & parsedInteger;
			
			upperBits = upperBits >>> 10;

			upperBits = 0b00000000000000001101100000000000 | upperBits;
			lowerBits = 0b00000000000000001101110000000000 | lowerBits;
			
			upperBits = upperBits << 16;

			int result = upperBits | lowerBits;
			return String.format("%08X", result);
		} else {
			return null;
		}
	}
	
	/**
	 * Converts the code point to a UTF-32 representation
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return The UTF-32 version of the code point
	 */
	
	public String toUTF32() {
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, 16);
		return String.format("%08X", parsedInteger);
	}
}
