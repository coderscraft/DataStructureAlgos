package com.ravi.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	private char data;
	
	private List<TrieNode> childNodes;
	
	private boolean wordEnd;

	public TrieNode(char data) {
		super();
		this.data = data;
		this.childNodes = new ArrayList<>();
	}
	
	
	public TrieNode getMatchingChildNode(char data) {
		
		for(TrieNode tnode : this.getChildNodes() ) {
			if(tnode.getData() == data) {
				return tnode;
			}
		}
		return null;
	}


	public char getData() {
		return data;
	}



	public void setWordEnd(boolean wordEnd) {
		this.wordEnd = wordEnd;
	}


	public List<TrieNode> getChildNodes() {
		return childNodes;
	}

	public boolean isWordEnd() {
		return wordEnd;
	}

	
}
