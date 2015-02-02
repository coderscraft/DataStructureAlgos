package com.ravi.problems;

public class Suduku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int sudu[][] = new int[4][4];
		
		
		
		sudu[0][0] = 1;
		sudu[0][2] = 3;
		sudu[1][1] = 3;
		sudu[1][2] = 1;
		sudu[2][1] = 1;
		sudu[2][2] = 4;
		sudu[3][2] = 2;
		sudu[3][3] = 1;
		
	  /*1  2  3  4
		4  3  1  2
        2  1  4  3
        3  4  2  1 */
		
		evalSuduku(sudu);
		
	}

	private static void evalSuduku(int[][] sudu) {

		
        
	}

}
