package com.ravi.problems;

public class Permutation {
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4};
		perm(a, 0, 4);
		
	}
	
	public static void perm(int[] a, int k, int n) {
		if(k == n) {
			System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
		} else {
			for(int i = k; i < n; i++) {
				int t = a[i];
				a[i] = a[k];
				a[k] = t;
				perm(a,k+1,n);
			    t = a[i];
				a[i] = a[k];
				a[k] = t;
			}
		}
	}
}
