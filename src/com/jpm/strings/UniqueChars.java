package com.jpm.strings;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 1.1 Implement an algorithm to determine if a string has all unique
 * characters. What if you can not use additional data structures? pg 48
 * 
 * Both solutions assume that chars are ASCII and lowercase
 * @author JPMagalhaes
 * 
 */
public class UniqueChars {

	// using no additional data structures, just a int
	public static boolean isUniqueCharsBit(String str) {
		if(str == null)
			return false;
		else if (str.length() == 0)
			return true;
		
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			int v = str.charAt(i) - 'a';
			if((result & (1 << v)) > 0)
				return false;
			result |= (1 << v);
		}
		return true;
	}
	
	public static boolean isUniqueChars(String str) {
		if(str == null)
			return false;
		if(str.length() <= 1)
			return true;
		
		boolean[] isUnique = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(isUnique[c])
				return false;
			
			isUnique[c] = true;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] in = { "a", "aa", "abc", "abca", null, "", "abcdefgh", "abcdefghh", "abc abc", "abc def"};
		boolean[] out = { true, false, true, false, false, true, true, false, false, true};
		int count = 0;
		for(int i = 0; i < in.length; i++){
			System.out.println(in[i] + ": " + isUniqueCharsBit(in[i]));
			if (isUniqueCharsBit(in[i]) == out[i]) count++;
			System.out.println("RESULT: " + count + "/" + (i+1));
		}
		System.out.println("RESULT: " + count + "/" + in.length);
		
	}

}
