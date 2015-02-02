package com.ravi.random;

public class Caller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringEnhancer enhancer = new StringEnhancer("abcd");
		
		System.out.println(enhancer.processIt().equals("abcd"));
		
		
	}

}
