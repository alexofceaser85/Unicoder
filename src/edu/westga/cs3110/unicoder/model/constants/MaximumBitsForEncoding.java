package edu.westga.cs3110.unicoder.model.constants;

/**
 * Holds the maximum bits for each byte encoding
 * 
 * @author Alex DeCesare
 * @version 20-September-2021
 */
public class MaximumBitsForEncoding {

	public static final int MAXIMUM_BITS_FOR_ONE_BYTE_UTF_EIGHT = 127;
	public static final int MAXIMUM_BITS_FOR_TWO_BYTE_UTF_EIGHT = 2047;
	public static final int MAXIMUM_BITS_FOR_THREE_BYTES_UTF_EIGHT = 65535;
	public static final int MAXIMUM_BITS_FOR_FOUR_BYTES_UTF_EIGHT = 1114111;
	
	public static final int MAXIMUM_BITS_FOR_FIRST_GROUP_OF_TWO_BYTE_UTF_SIXTEEN = 55295;
	public static final int MINUMUM_BITS_FOR_SECOND_GROUP_OF_TWO_BYTE_UTF_SIXTEEN = 57344;
	public static final int MAXIMUM_BITS_FOR_SECOND_GROUP_OF_TWO_BYTE_UTF_SIXTEEN = 65535;
	public static final int MINIMUM_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 65536;
	public static final int MAXIMUM_BITS_FOR_FOUR_BYTE_UTF_SIXTEEN = 1114111;
}
