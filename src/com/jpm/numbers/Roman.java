package com.jpm.numbers;

/**
 * This is not a problem from the book.
 * 
 * Write a function to convert an integer to and from Roman numerals
 * 
 * @author JPMagalhaes
 *
 */
public class Roman {
	public static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	public static final int[] INTEGERS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
	
	public static String intToRoman(int in) {
		if(in <= 0 || in >= 4000)
			return "";
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < INTEGERS.length; i++) {
			int temp = in/INTEGERS[i];
			while (temp > 0) {
				builder.append(ROMANS[i]);
				temp--;
				in -= INTEGERS[i];
			}
		}
		
		return builder.toString();
	}
	
	public static int roman2Int(String in) {
		if(in == null || in.length() == 0)
			return 0;
		
		int value = 0;
		String temp = new String(in);
		for (int i = 0; i < ROMANS.length; i++) {
			while (temp.startsWith(ROMANS[i])) {
				value += INTEGERS[i];
				temp = temp.substring(ROMANS[i].length());
			}
		}
		
		return value;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] in = { 1, 3, 4, 5, 8, 9, 10, 13, 14, 15, 20, 39, 40, 49, 50, 80, 90, 99, 100, 399, 400, 500, 800, 850, 900, 999, 1000, 3999 };
		String[] in2 = {"I" , "III" , "IV" , "V" , "VIII" , "IX" , "X" , "XIII" , "XIV" , "XV" , "XX" , "XXXIX" , "XL" , "XLIX" , "L" , "LXXX" , "XC" , "XCIX" , "C" , "CCCXCIX" , "CD" , "D" , "DCCC" , "DCCCL" , "CM" , "CMXCIX" , "M" , "MMMCMXCIX"};
		for(String s : in2) {
			System.out.println(s + " = " + roman2Int(s));
		}
		for (int i : in) {
			System.out.println(i + " = " + intToRoman(i));
		}
	}

}
