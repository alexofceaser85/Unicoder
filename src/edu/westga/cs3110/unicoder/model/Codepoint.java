package edu.westga.cs3110.unicoder.model;

import edu.westga.cs3110.unicoder.errormessages.CodepointErrorMessages;
import edu.westga.cs3110.unicoder.model.constants.AdditionBits;
import edu.westga.cs3110.unicoder.model.constants.BitMasks;
import edu.westga.cs3110.unicoder.model.constants.FormattingOptions;
import edu.westga.cs3110.unicoder.model.constants.MaximumBitsForEncoding;
import edu.westga.cs3110.unicoder.model.constants.ShiftAmounts;

/**
 * Gets the code point for given UTF encodings
 * 
 * @author Alex DeCesare
 * @version 17-September-2021
 */

public class Codepoint {
	
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
	public Codepoint(String codePoint) {
		
		if (codePoint == null) {
			throw new IllegalArgumentException(CodepointErrorMessages.NULL_CODE_POINT_ERROR_MESSAGE);
		}
		if (codePoint.isEmpty()) {
			throw new IllegalArgumentException(CodepointErrorMessages.EMPTY_CODE_POINT_ERROR_MESSAGE);
		}
		if (!codePoint.matches(validCodePointRegex)) {
			throw new IllegalArgumentException(CodepointErrorMessages.INVALID_CODE_POINT_ERROR_MESSAGE);
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
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, FormattingOptions.INTEGER_PARSE_BASE);
		
		if (parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_ONE_BYTE_UTF_EIGHT) {
			return String.format(FormattingOptions.HEXADECIMAL_TWO_DIGIT_FORMAT, parsedInteger);
		} else if (parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_TWO_BYTE_UTF_EIGHT) {
			int result = this.convertToFourDigitUTF8(parsedInteger);
			return String.format(FormattingOptions.HEXADECIMAL_FOUR_DIGIT_FORMAT, result);
		} else if (parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_THREE_BYTES_UTF_EIGHT) {
			int result = this.convertToSixDigitUTF8(parsedInteger);
			return String.format(FormattingOptions.HEXADECIMAL_SIX_DIGIT_FORMAT, result);
		} else if (parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_FOUR_BYTES_UTF_EIGHT) {
			int result = this.convertToEightDigitUTF8(parsedInteger);
			return String.format(FormattingOptions.HEXADECIMAL_EIGHT_DIGIT_FORMAT, result);
		} else {
			return null;
		}
	}

	private int convertToFourDigitUTF8(int parsedInteger) {
		int firstByte = parsedInteger & BitMasks.MASK_FOR_FIRST_BYTE_IN_TWO_BYTE_UTF_EIGHT;
		int secondByte = parsedInteger & BitMasks.MASK_FOR_SECOND_BYTE_IN_TWO_BYTE_UTF_EIGHT;
		
		firstByte = AdditionBits.BYTES_TO_ADD_TO_FIRST_BYTE_FOR_TWO_BYTE_UTF_EIGHT | firstByte;
		secondByte = AdditionBits.BYTES_TO_ADD_TO_SECOND_BYTE_FOR_TWO_BTYE_UTF_EIGHT | secondByte;
		
		firstByte = firstByte << ShiftAmounts.SHIFT_FIRST_BYTE_BY_TWO_FOR_TWO_BYTE_UTF_EIGHT;
		
		int result = firstByte | secondByte;
		return result;
	}

	private int convertToSixDigitUTF8(int parsedInteger) {
		int firstByte = parsedInteger  & BitMasks.MASK_FOR_FIRST_BYTE_IN_THREE_BYTE_UTF_EIGHT;
		int secondByte = parsedInteger & BitMasks.MASK_FOR_SECOND_BYTE_IN_THREE_BYTE_UTF_EIGHT;
		int thirdByte = parsedInteger  & BitMasks.MASK_FOR_THIRD_BYTE_IN_THREE_BYTE_UTF_EIGHT;

		firstByte =  AdditionBits.BYTES_TO_ADD_TO_FIRST_BYTE_FOR_THREE_BYTE_UTF_EIGHT | firstByte;
		secondByte = AdditionBits.BYTES_TO_ADD_TO_SECOND_BYTE_FOR_THREE_BYTE_UTF_EIGHT | secondByte;
		thirdByte =  AdditionBits.BYTES_TO_ADD_TO_THIRD_BYTE_FOR_THREE_BYTE_UTF_EIGHT | thirdByte;
		
		firstByte = firstByte << ShiftAmounts.SHIFT_FIRST_BYTE_BY_FOUR_FOR_THREE_BYTE_UTF_EIGHT;
		secondByte = secondByte << ShiftAmounts.SHIFT_SECOND_BYTE_BY_TWO_FOR_THREE_BYTE_UTF_EIGHT;
		
		int result = firstByte | secondByte | thirdByte;
		return result;
	}

	private int convertToEightDigitUTF8(int parsedInteger) {
		int firstByte = parsedInteger  & BitMasks.MASK_FOR_FIRST_BYTE_IN_FOUR_BYTE_UTF_EIGHT;
		int secondByte = parsedInteger & BitMasks.MASK_FOR_SECOND_BYTE_IN_FOUR_BYTE_UTF_EIGHT;
		int thirdByte = parsedInteger  & BitMasks.MASK_FOR_THIRD_BYTE_IN_FOUR_BYTE_UTF_EIGHT;
		int fourthByte = parsedInteger & BitMasks.MASK_FOR_FOURTH_BYTE_IN_FOUR_BYTE_UTF_EIGHT;
		
		firstByte = AdditionBits.BYTES_TO_ADD_TO_FIRST_BYTE_FOR_FOUR_BYTE_UTF_EIGHT | firstByte;
		secondByte = AdditionBits.BYTES_TO_ADD_TO_SECOND_BYTE_FOR_FOUR_BYTE_UTF_EIGHT | secondByte;
		thirdByte = AdditionBits.BYTES_TO_ADD_TO_THIRD_BYTE_FOR_FOUR_BYTE_UTF_EIGHT | thirdByte;
		fourthByte = AdditionBits.BYTES_TO_ADD_TO_FOURTH_BYTE_FOR_FOUR_BYTE_UTF_EIGHT | fourthByte;
		
		firstByte = firstByte << ShiftAmounts.SHIFT_FIRST_BYTE_BY_SIX_FOR_FOUR_BYTE_UTF_EIGHT;
		secondByte = secondByte << ShiftAmounts.SHIFT_SECOND_BYTE_BY_FOUR_FOR_FOUR_BYTE_UTF_EIGHT;
		thirdByte = thirdByte << ShiftAmounts.SHIFT_THIRD_BYTE_BY_TWO_FOR_FOUR_BYTE_UTF_EIGHT;
		
		int result = firstByte | secondByte | thirdByte | fourthByte;
		return result;
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
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, FormattingOptions.INTEGER_PARSE_BASE);
		
		if (parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_FIRST_GROUP_OF_TWO_BYTE_UTF_SIXTEEN || (parsedInteger >= MaximumBitsForEncoding.MINUMUM_BITS_FOR_SECOND_GROUP_OF_TWO_BYTE_UTF_SIXTEEN && parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_SECOND_GROUP_OF_TWO_BYTE_UTF_SIXTEEN)) {
			return String.format(FormattingOptions.HEXADECIMAL_FOUR_DIGIT_FORMAT, parsedInteger);
		} else if (parsedInteger >= MaximumBitsForEncoding.MINIMUM_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN && parsedInteger <= MaximumBitsForEncoding.MAXIMUM_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN) {
			int result = this.convertToEightDigitUTF16(parsedInteger);
			return String.format(FormattingOptions.HEXADECIMAL_EIGHT_DIGIT_FORMAT, result);
		} else {
			return null;
		}
	}

	private int convertToEightDigitUTF16(int parsedInteger) {
		parsedInteger = parsedInteger - 0x10000;
		
		int upperBits = BitMasks.MASK_FOR_UPPER_TEN_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN & parsedInteger;
		int lowerBits = BitMasks.MASK_FOR_LOWER_TEN_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN & parsedInteger;
		
		upperBits = upperBits >>> ShiftAmounts.SHIFT_UPPER_BITS_RIGHT_BY_TEN_FOR_ADDITION_OF_OTHER_BITS;

		upperBits = AdditionBits.BYTES_TO_ADD_TO_UPPER_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN | upperBits;
		lowerBits = AdditionBits.BYTES_TO_ADD_TO_LOWER_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN | lowerBits;
		
		upperBits = upperBits << ShiftAmounts.SHIFT_UPPER_BITS_LEFT_BY_SIXTEEN_TO_MOVE_TO_STARTING_BYTES;

		int result = upperBits | lowerBits;
		return result;
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
		int parsedInteger = Integer.parseUnsignedInt(this.codePoint, FormattingOptions.INTEGER_PARSE_BASE);
		return String.format(FormattingOptions.HEXADECIMAL_EIGHT_DIGIT_FORMAT, parsedInteger);
	}
}
