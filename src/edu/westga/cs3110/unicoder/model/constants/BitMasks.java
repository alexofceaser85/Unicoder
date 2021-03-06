package edu.westga.cs3110.unicoder.model.constants;

/**
 * Holds the bitmasks for the application
 * 
 * @author Alex DeCesare
 * @version 20-September-2021
 */

public final class BitMasks {

	public static final int MASK_FOR_FIRST_BYTE_IN_TWO_BYTE_UTF_EIGHT = 0b0000011111000000;
	public static final int MASK_FOR_SECOND_BYTE_IN_TWO_BYTE_UTF_EIGHT = 0b0000000000111111;
	
	public static final int MASK_FOR_FIRST_BYTE_IN_THREE_BYTE_UTF_EIGHT = 0b000000001111000000000000;
	public static final int MASK_FOR_SECOND_BYTE_IN_THREE_BYTE_UTF_EIGHT = 0b000000000000111111000000;
	public static final int MASK_FOR_THIRD_BYTE_IN_THREE_BYTE_UTF_EIGHT = 0b000000000000000000111111;
	
	public static final int MASK_FOR_FIRST_BYTE_IN_FOUR_BYTE_UTF_EIGHT = 0b00000000000111000000000000000000;
	public static final int MASK_FOR_SECOND_BYTE_IN_FOUR_BYTE_UTF_EIGHT = 0b00000000000000111111000000000000;
	public static final int MASK_FOR_THIRD_BYTE_IN_FOUR_BYTE_UTF_EIGHT = 0b00000000000000000000111111000000;
	public static final int MASK_FOR_FOURTH_BYTE_IN_FOUR_BYTE_UTF_EIGHT = 0b00000000000000000000000000111111;
	
	public static final int MASK_FOR_UPPER_TEN_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 0b00000000000011111111110000000000;
	public static final int MASK_FOR_LOWER_TEN_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 0b00000000000000000000001111111111;
}
