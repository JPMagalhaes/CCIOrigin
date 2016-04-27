package com.jpm.strings;

/**
 * Cracking the coding Interview, 4 edition
 * 1.8 Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle”
 * is a rotation of “erbottlewat”). pg 48
 * 
 * @author JPMagalhaes
 * 
 */
public class StringRotation {
	
	public static boolean isStringRotation(String s1, String s2){
		if(s1 == null || s2 == null)
			return false;
		int lenS1 = s1.length(), lenS2 = s2.length();
		if(lenS1 != lenS2)
			return false;
		if(lenS1 == 0)
			return true;
		
		return (s1+s1).contains(s2);
	}

	public static boolean isStringRotationInPlace(String s1, String s2){
		if(s1 == null || s2 == null)
			return false;
		int lenS1 = s1.length(), lenS2 = s2.length();
		if(lenS1 != lenS2)
			return false;
		if(lenS1 == 0)
			return true;
		
		int index = -1;
		for (int i = 0, j = 0; j < lenS2; j++) {
			if(s1.charAt(i) == s2.charAt(j)) {
				if(index == -1)
					index = j;
				
				i++;
			} else {
				index = -1;
				i = 0;
			}
		}
		
		if(index == -1)
			return false;
		else if(index == 0)
			return true;
		else {
			String s = s2.substring(0, index);
			System.out.println(s1 + " contains " + s);
			return s1.contains(s);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] in = {
				"waterbottle",
				"waterbottle",
				"asd",
				"asdfg",
				"a",
				"aa",
				"ab",
				"aaaaab",
				"aaaaab",
				"",
				null,
				"abcdefg"
		};
		
		String[] in2 = {
				"erbottlewat",
				"erbotltewat",
				"das",
				"asdfg",
				"a",
				"aa",
				"ba",
				"aaaaba",
				"baaaaa",
				"",
				null,
				"abcdegf"
		};
		
		boolean[] out = {
				true,
				false,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				false,
				false
		}; 
		int count = 0;
		for (int i = 0; i < out.length; i++) {
			boolean r = isStringRotation(in[i], in2[i]);
			System.out.println("input (" + i + "): " + in[i] + "::" + in2[i]);
			System.out.println("isStringRotation: " + r);
			System.out.println("RESULT: " + (r == out[i] ? ++count : count) + "/" + (i+1));
		}
	}

}
