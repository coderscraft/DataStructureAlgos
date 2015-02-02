package com.ravi.problems;

/*
 * Long subsequence in two string can be found using simple formula
 * 
 * s(a[i], b[j]) =  1 + s(a[i-1], b[j-1]) if a[i] = b[j] or
 *               =  max(s(a[i][j-1]), s([i-1],[j]))
 *               
 * we find out this sequence from smallest set like s(a[1],b[1]) and move till s(a[i],b[j])              
 * 
 */


public class LongSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		String b[] = {"f","a","v","c","w","d","a","b","c"};
		String a[] = {"a","b","s","c","w","d","a","w","c"};
		
        getLongestString(a,b);
		
	}

	private static void getLongestString(String[] a, String[] b) {
		
		int x = a.length;
		int y = b.length;
		
		int matrix[][] = new int[x + 1][y + 1];
		String data[][] = new String[x + 1][y + 1];
		
		for(int i = 0; i <= x; i++) {
			for( int j =0; j <= y; j++) {
				 if( i == 0 || j == 0) {
		        	 matrix[i][j] = 0;   	 
		         } else {
		        	 if(a[i - 1] == b[j - 1]) {
						 matrix[i][j] = 1 + matrix[i-1][j-1];
						 data[i][j] = a[i - 1];
					} else {
						
						 matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
					}	 
		         }
			}
		}
		
		
		for(int i = 0; i <= x; i++) {
			for( int j =0; j <= y; j++) {
		         System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		
		for(int i = 0; i <= x; i++) {
			for( int j =0; j <= y; j++) {
		         System.out.print(data[i][j] == null? "- ": data[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

}
