package com.ravi.problems;

public class Combination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      
		String str = "abc";
		StringBuffer sb = new StringBuffer();
		combination(str, sb, 0, 3);
	}

	
	public static void combination(String str, StringBuffer sb, int StartPosAllow, int length) {
		
		if(StartPosAllow > length -1) {
			return;
		} else {
			for(int i = StartPosAllow; i < length; i++ ) {
				sb.append(str.charAt(i));
				System.out.println(sb.toString());
				combination(str, sb, i + 1, length);
				sb.deleteCharAt(sb.length() - 1);
			}
			
		}
		
		
	}
	
	
}
