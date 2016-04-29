package com.jpm.arrays;

public final class Utils {

	public static void printMatrix(int [][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean areMatrixEquals(int [][] in1, int [][] in2) {
		if(in1 == null || in2 == null)
			return false;
		int xLen1 = in1.length, xLen2 = in2.length;
		
		if(xLen1 !=  xLen2)
			return false;
		else if(xLen1 == 0)
			return true;
		
		for (int i = 0; i < xLen1; i++) {
			int yLen1 = in1[i].length, yLen2 = in2[i].length;
			if(yLen1 != yLen2)
				return false;
			for (int j = 0; j < yLen1; j++) {
				if(in1[i][j] != in2[i][j])
					return false;
			}
		}
		
		return true;
	}

}
