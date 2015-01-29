package com.ravi.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/*
 * Simple concept to solve this problem:
 * 
 * S is sum and p(s) minimum count to get is from {v1, v2... vn} units
 * 
 * formula:    p(s) = min all ( p(s - vi) ) + 1
 * 
 *  (p (s - vi))  can besolved recursively which will give minimum sum needed start from 0 till S and all result
 *   can be cached for next use. can build simple tree
 *   
 *    assume  s= 6    v = { 1, 2, 3}
 *    
 *                        6
 *                 |      |     |       
 *          min( 6-1 =5  6-2=4   6-3=3 ) + 1
 *                |
 *           |    |     |
 *  min (5-1=4   5-2=3  5-3=3 ) + 1   
 */


public class CoinProblem {

	
	
	public static int[] minCount;
	
	public static int[] minCurrrency;
	
	public static int[] minCurrrencyNum;
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] currency = {1,2,3};
		int sum = 62;

		minCount = new int[sum];
		minCurrrency = new int[sum];
		minCurrrencyNum = new int[sum];
		
		for(int i=0; i < minCount.length; i++) {
			minCount[i] = -1;
			minCurrrency[i] = -1;
			minCurrrencyNum[i] = -1;
		}
		
		int count = getMinimumCoinCount(currency,sum);
		
		System.out.println("Min count : " + count);
		
		System.out.println("Amount Currency  Sum");
		
		for(int i=0; i < minCount.length; i++) {
			
			System.out.println(i+1 + " "+ minCurrrency[i] + " " + minCurrrencyNum[i]);
			
		}
		
		int i = sum;
		
		System.out.println("Currencies: ");
		while( i > 0) {
			
			System.out.println(minCurrrency[i-1]);
			i = i - minCurrrency[i-1];
			
		}
		
		
	}

	private static int getMinimumCoinCount(int[] currency, int sum) {
		
		System.out.println(sum);
		
		if(sum == 0) {
			return 0;
		} else {
			
			if(minCount[sum - 1] != -1) {
				return minCount[sum - 1];
			} else {
				TreeSet<Integer> minTree = new TreeSet();
				Map<Integer,CountClass> minCountMap = new HashMap<>();
				for(int i = 0; i < currency.length; i++ ) {
					if(sum >= currency[i]) {
						
						int newsum =  sum - currency[i];
						int  minCount = getMinimumCoinCount(currency, newsum);
						minCountMap.put(minCount, new CountClass(currency[i],newsum));
						minTree.add(minCount);	
					}
				}
				
				CountClass c = minCountMap.get( minTree.first());
				minCurrrency[sum -1] = c.currency;
				minCurrrencyNum[sum -1] = c.sum;
				int count =  minTree.first() + 1;
				minCount[sum -1] = count;
				return  count;		
			}
		}
		
	}

}
