package edu.westga.cs3110.unicoder.model.constants;

/**
 * Holds the bits that are added onto other bits
 * 
 * @author Alex DeCesare
 * @version 20-September-2021
 */

public final class AdditionBits {

	public static final int BYTES_TO_ADD_TO_FIRST_BYTE_FOR_TWO_BYTE_UTF_EIGHT = 0b0011000000000000;
	public static final int BYTES_TO_ADD_TO_SECOND_BYTE_FOR_TWO_BTYE_UTF_EIGHT = 0b0000000010000000;
	
	public static final int BYTES_TO_ADD_TO_FIRST_BYTE_FOR_THREE_BYTE_UTF_EIGHT = 0b000011100000000000000000;
	public static final int BYTES_TO_ADD_TO_SECOND_BYTE_FOR_THREE_BYTE_UTF_EIGHT = 0b000000000010000000000000;
	public static final int BYTES_TO_ADD_TO_THIRD_BYTE_FOR_THREE_BYTE_UTF_EIGHT = 0b000000000000000010000000;
	
	public static final int BYTES_TO_ADD_TO_FIRST_BYTE_FOR_FOUR_BYTE_UTF_EIGHT = 0b00000011110000000000000000000000;
	public static final int BYTES_TO_ADD_TO_SECOND_BYTE_FOR_FOUR_BYTE_UTF_EIGHT = 0b00000000000010000000000000000000;
	public static final int BYTES_TO_ADD_TO_THIRD_BYTE_FOR_FOUR_BYTE_UTF_EIGHT = 0b00000000000000000010000000000000;
	public static final int BYTES_TO_ADD_TO_FOURTH_BYTE_FOR_FOUR_BYTE_UTF_EIGHT = 0b00000000000000000000000010000000;
	
	public static final int BYTES_TO_ADD_TO_UPPER_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 0b00000000000000001101100000000000;
	public static final int BYTES_TO_ADD_TO_LOWER_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 0b00000000000000001101110000000000;
}