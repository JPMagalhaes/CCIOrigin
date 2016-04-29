package com.jpm.arrays;

import java.util.HashSet;

/**
 * Cracking the coding Interview, 4 edition
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0.
 * 
 * @author JPMagalhaes
 * 
 */
public class MatrixSetZeros {

	public static void setZeros(int[][] in){
		if(in == null || in.length == 0)
			return;
		HashSet<Integer> lines = new HashSet<Integer>();
		HashSet<Integer> collumns = new HashSet<Integer>();
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				if(in[i][j] == 0){
					lines.add(i);
					collumns.add(j);
				}
			}
		}
		for (Integer i : lines) {
			setLineZeros(in, i);
			System.out.println("line zeroed");
			Utils.printMatrix(in);
		}
		for (Integer j : collumns) {
			setCollumnZeros(in, j);
			System.out.println("collumn zeroed");
			Utils.printMatrix(in);
		}
	}
	
	private static void setLineZeros(int[][] in, int i) {
		for (int j = 0; j < in[i].length; j++) {
			in[i][j] = 0;
		}
	}
	
	private static void setCollumnZeros(int[][] in, int j) {
		for (int i = 0; i < in.length; i++) {
			in[i][j] = 0;
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
		int[][] in02 = {{1, 01, 02, 03},
				{10, 11, 12, 13},
				{20, 21, 22, 23},
				{30, 31, 32, 33}};
		int[][] in03 = {{0, 0, 02},
				{10, 11, 12},
				{20, 21, 22},
				{30, 31, 32}};
		int[][] in1 = {{00}};
		int[][] in12 = {{01}};
		int[][] in2 = {{01, 02},
				{10, 0}};
		int[][] in3 = {{1, 01, 0},
				{10, 0, 12},
				{0, 21, 22}};
		int[][] in5 = {{0, 01, 02, 03, 04},
				{10, 0, 12, 13, 14},
				{20, 21, 22, 23, 24},
				{30, 31, 32, 0, 34},
				{40, 41, 42, 43, 0}};
		
		int[][][] input = {in,in02,in03,in1, in12, in2,in3, in5};
		
		int[][] out = {{00, 0, 0, 0},
				{0, 11, 12, 13},
				{0, 21, 22, 23},
				{0, 31, 32, 33}};
		int[][] out02 = {{1, 01, 02, 03},
				{10, 11, 12, 13},
				{20, 21, 22, 23},
				{30, 31, 32, 33}};
		int[][] out03 = {{0, 0, 0},
				{0, 0, 12},
				{0, 0, 22},
				{0, 0, 32}};
		int[][] out1 = {{00}};
		int[][] out12 = {{01}};
		int[][] out2 = {{01, 0},
				{0, 0}};
		int[][] out3 = {{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}};
		int[][] out5 = {{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 22, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0}};
		
		int[][][] output = {out,out02,out03,out1, out12,out2, out3, out5};
		int count = 0;
		for (int j = 0; j < output.length; j++) {
			System.out.println("Input");
			Utils.printMatrix(input[j]);
			setZeros(input[j]);
			System.out.println("Output");
			Utils.printMatrix(input[j]);
			System.out.println("RESULT: " + (Utils.areMatrixEquals(input[j], output[j]) == true ? ++count : count) + "/" + (j+1));
		}

	}

}
