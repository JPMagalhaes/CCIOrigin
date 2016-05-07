package com.jpm.sort;

import java.util.Arrays;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] in = {{1},
					  {1,2},
					  {2,1},
					  {2,1,3},
					  {3,2,1},
					  {1,2,3,4,5,0},
					  {1,2,3,5,4},
					  {1,2,3,5,4,6}};
		int[][] out = {{1},
					   {1,2},
					   {1,2},
					   {1,2,3},
					   {1,2,3},
					   {0,1,2,3,4,5},
					   {1,2,3,4,5},
					   {1,2,3,4,5,6}};
		
		int count = 0;
		for (int i = 0; i < out.length; i++) {
			System.out.println();
			System.out.print(Arrays.toString(in[i]) + " :: ");
			int[] result = quickSort(in[i]);
			
			System.out.println(Arrays.toString(result));
			System.out.println((Arrays.equals(result, out[i]) ? ++count : count) + " / " + (i+1));
		}
		
	}

	private static int[] quickSort(int[] in) {
		if(in == null || in.length < 2)
			return in;
		return quickSort(in, 0, in.length - 1);
	}

	private static int[] quickSort(int[] in, int start, int end) {
		if(end <= start)
			return in;
		
		int e = end, s = start;
		while(e > s){
			if(in[e] < in[s]) {
				int temp = in[e];
				in[e] = in[s];
				in[s] = in[e-1];
				in[e-1] = temp;
				e--;
			} else
				s++;
		}
		
		quickSort(in, start, e-1);
		quickSort(in, e+1, end);
		
		return in;
	}

}
