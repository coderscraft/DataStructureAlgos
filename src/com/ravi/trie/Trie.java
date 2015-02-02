package com.ravi.trie;

public class Trie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "hello how are you";
		
		TrieNode  root = new TrieNode(' ');

		initTrie(str, root);
		
		boolean isthere = search("are", root);
		
		System.out.println("are exist : " + isthere );
		
		isthere = search("aree", root);
		
		System.out.println("aree exist : " + isthere );
		
		System.out.println(root.getData());
		
	}

	private static boolean search(String pattern, TrieNode root) {
		TrieNode node = root;
		for(int i = 0; i < pattern.length(); i++) {
			node = node.getMatchingChildNode(pattern.charAt(i));
			if(node == null) {
				return false;
			}
		}
 		return true;
	}

	private static void initTrie(String str, TrieNode root) {
		
		String[] tokens = str.split(" ");
		
		
		
		for( int i = 0; i < tokens.length; i++)  {
			System.out.println(tokens[i]);
			TrieNode baseNode = root;
		
			for(int j = 0; j < tokens[i].length(); j++) {
				
				baseNode = buildTrie(tokens[i].charAt(j),baseNode);
				
			}
			baseNode.setWordEnd(true);
		}
		
		
		
	}
	
	
	
	public static TrieNode buildTrie(char chr, TrieNode root) {
		TrieNode node = root.getMatchingChildNode(chr);
        if(node == null) {
        	TrieNode newNode = new TrieNode(chr);
        	root.getChildNodes().add(newNode);
        	return newNode;
        } else {
        	return node;
        }
	}
	
	
	
}
