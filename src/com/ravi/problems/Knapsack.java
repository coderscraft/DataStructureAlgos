package com.ravi.problems;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

	/**
	 * @param args
	 * 
	 * Create Matrix of : item 0 to n
	 * and weight 0 to w (max weight)
	 * 0th row and column with have 0 data as benifit
	 * any cell value is b(i,w) that is benifit for item till i and weight till w 
	 *   
	 * algo is: maximum of b(i-1, w(i)) or b(i,w(i)) + b(i-1, w - w(i)) where w(i) <= w
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     int[] b = {5,3,4};
	     int[] w = {3,2,1};
		
	     int maxWeight = 5;
	     
	     getBenifit(b,w,maxWeight);

	}

	private static void getBenifit(int[] b, int[] w, int maxWeight) {
		
		int length = b.length;
		int width = maxWeight;
		List<Integer> item = new ArrayList<>();
		
		int[][] benifit = new int[length + 1][maxWeight +1];
		int[][] keep = new int[length + 1][maxWeight + 1];
		
		for ( int i = 0 ; i <= length; i++) {
			for(int j = 0; j <= width; j++) {
            
				if(i == 0 || j == 0) {
					benifit[i][j] = 0;
					keep[i][j] = 0;
				} else {
	                  
					int option1 = benifit[i-1][j];
					System.out.print(i + " " +  j + " "  + option1);
					int option2 = 0;
					if(j >= w[i-1]) {
						option2 = b[i-1] +  benifit[i-1][j-w[i-1]];
					}
					
					System.out.println( " " + option2);
					int finalBenifit = Math.max(option1, option2);
					benifit[i][j] = finalBenifit;
					if(finalBenifit == option2) {
						keep[i][j] = 1;
					}
				}
			}
		}
		
		for ( int i = 0 ; i <= length; i++) {
			for(int j = 0; j <= width; j++) {
			   System.out.print(benifit[i][j]);	
			}
		      System.out.println("");
		}
		
		for ( int i = 0 ; i <= length; i++) {
			for(int j = 0; j <= width; j++) {
			   System.out.print(keep[i][j] + " ");	
			}
		      System.out.println("");
		}
		
		getNextEl(keep,length,width, w, b);
		
	
	}

	private static void getNextEl(int[][] keep, int length, int width, int[] w,  int[] b) {
		
           if(length == 0) {
        	   return;
           } else {
        	   if(keep[length][width] == 1) {
        		   System.out.println(length + " " + w[length - 1] + " " + b[length -1]);
        		   width = width - w[length - 1];
        		   length = length - 1;
        		   getNextEl(keep,length,width, w, b);
        	   } else {
        		   length = length - 1;
        		   getNextEl(keep,length,width, w, b);
        	   }
        	   
           }
		
	}

}
