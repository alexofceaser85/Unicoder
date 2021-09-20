package edu.westga.cs3110.unicoder.model.constants;

/**
 * Holds the amounts for the shifts
 * 
 * @author Alex DeCesare
 * @version 20-September-2021
 */
public class ShiftAmounts {

	public static final int SHIFT_FIRST_BYTE_BY_TWO_FOR_TWO_BYTE_UTF_EIGHT = 2;
	
	public static final int SHIFT_FIRST_BYTE_BY_FOUR_FOR_THREE_BYTE_UTF_EIGHT = 4;
	public static final int SHIFT_SECOND_BYTE_BY_TWO_FOR_THREE_BYTE_UTF_EIGHT = 2;
	
	public static final int SHIFT_FIRST_BYTE_BY_SIX_FOR_FOUR_BYTE_UTF_EIGHT = 6;
	public static final int SHIFT_SECOND_BYTE_BY_FOUR_FOR_FOUR_BYTE_UTF_EIGHT = 4;
	public static final int SHIFT_THIRD_BYTE_BY_TWO_FOR_FOUR_BYTE_UTF_EIGHT = 2;
	
	public static final int SHIFT_UPPER_BITS_RIGHT_BY_TEN_FOR_ADDITION_OF_OTHER_BITS = 10;
	public static final int SHIFT_UPPER_BITS_LEFT_BY_SIXTEEN_TO_MOVE_TO_STARTING_BYTES = 16;
}
