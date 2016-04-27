package com.jpm.arrays;

/**
 * Cracking the coding Interview, 4 edition
 * 
 * 1.6 Given an image represented by an NxN matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees. Can you
 * do this in place? pg 48
 * 
 * @author JPMagalhaes
 * 
 */
public class RotateImage {
	
	public static void rotateInPlace(int[][] matrix) {
		if(matrix == null || matrix.length < 2)
			return;
		
		int xLen = matrix.length;
		for (int i = 0; i < xLen/2; i++) {
			int yLen = matrix[i].length;
			if(yLen != xLen)
				return;
			
			for (int j = i; j < yLen-1-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[yLen-1-j][i];
				matrix[yLen-1-j][i] = matrix[yLen-1-i][xLen-1-j];
				matrix[yLen-1-i][xLen-1-j] = matrix[j][xLen-1-i];
				matrix[j][xLen-1-i] = temp;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] in = {{00, 01, 02, 03},
				{10, 11, 12, 13},
				{20, 21, 22, 23},
				{30, 31, 32, 33}};
		int[][] in1 = {{00}};
		int[][] in2 = {{00, 01},
				{10, 11}};
		int[][] in3 = {{00, 01, 02},
				{10, 11, 12},
				{20, 21, 22}};
		int[][] in5 = {{00, 01, 02, 03, 04},
				{10, 11, 12, 13, 14},
				{20, 21, 22, 23, 24},
				{30, 31, 32, 33, 34},
				{40, 41, 42, 43, 44}};
		
		int[][][] input = {in,in1, in2,in3, in5};
		
		int[][] out = {{30, 20, 10, 0},
				{31, 21, 11, 1},
				{32, 22, 12, 2},
				{33, 23, 13, 3}};
		int[][] out1 = {{00}};
		int[][] out2 = {{10, 00},
				{11, 01}};
		int[][] out3 = {{20, 10, 00},
				{21, 11, 01},
				{22, 12, 02}};
		int[][] out5 = {{40, 30, 20, 10, 00},
				{41, 31, 21, 11, 01},
				{42, 32, 22, 12, 02},
				{43, 33, 23, 13, 03},
				{44, 34, 24, 14, 04}};
		
		int[][][] output = {out,out1, out2, out3, out5};
		int count = 0;
		for (int j = 0; j < output.length; j++) {
			System.out.println("Input");
			Utils.printMatrix(input[j]);
			rotateInPlace(input[j]);
			System.out.println("Output");
			Utils.printMatrix(input[j]);
			System.out.println("RESULT: " + (Utils.areMatrixEquals(input[j], output[j]) == true ? ++count : count) + "/" + (j+1));
		}
	}

}
