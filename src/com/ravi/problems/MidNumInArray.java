package com.ravi.problems;

public class MidNumInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = {1,4,5,3,6,4};
		
		findPos(a);
		
	}

	private static void findPos(int[] a) {
		
		int start = 0;
		int end = a.length - 1;
		
		int startSum = 0;
		int endSum = 0;
		
		
		while(start < end) {
			
			startSum = startSum + a[start];
			endSum = endSum + a[end];
			
			a[start] = 0;
			a[end] = 0;
			
			
			if( startSum < endSum) {
				start++;
			} else if ( endSum < startSum) {
				end--;
			} else if(startSum == endSum) {
				startSum = 0;
				endSum = 0;
				start++;
				end--;
			}
		}
		
		if(start == end && startSum == 0 && endSum == 0) {
			System.out.println("Mid :" + a[start]);
		} else {
			System.out.println("No mid");
		}
		
		
		
		
	}

}
