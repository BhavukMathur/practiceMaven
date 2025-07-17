package target2024.treeHeap;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
class TrieNode {
	TrieNode[] next;
	char info;
	boolean isLeaf;

	TrieNode(char info, boolean isLeaf) {
		this.next = new TrieNode[26];
		this.info = info;
		this.isLeaf = isLeaf;

		for(int i=0; i<26; i++) {
			this.next[i] = null;
		}
	}
}

public class TrieMain {
	public static void main(String[] args) {
		List<String> players = new ArrayList(Arrays.asList("sachin", "sehwag", "samson", "rahul", "ravindra",
				"ravichandran", "gambhir", "ganguly", "zaheer", "bumrah", "yuvraj", "kohli", "kuldeep"));

		TrieNode trieRoot = new TrieNode('\0', false);

		for(String player: players) {
			insertInTrie(trieRoot, player);
		}

		System.out.println("Printing the T9");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		while(!input.equals("exit")) {
			trieDisplay(input, trieRoot);
			input = sc.next();
		}
		System.out.println("Done");
	}

	private static void trieDisplay(String input, TrieNode trieRoot) {
		TrieNode trv = trieRoot;
		char ch;

		for(int i=0; i<input.length(); i++) {
			ch = input.charAt(i);

			if(trv.next[ch - 'a'] != null) {
				trv = trv.next[ch - 'a'];
			} else {
				System.out.println("No suggestion");
				return;
			}
		}

		//Print remaining
		printTrieSuggestion(trv, input);
	}

	private static void printTrieSuggestion(TrieNode trv, String input) {
		if(trv.isLeaf) {
			System.out.println(input);
			return;
		}

		for(int i=0; i<26; i++) {
			if(trv.next[i] != null) {
				printTrieSuggestion(trv.next[i], input + trv.next[i].info);
			}
		}
	}

	private static void insertInTrie(TrieNode trieRoot, String player) {

		char ch;
		TrieNode temp, trv = trieRoot;
		for(int i=0; i<player.length(); i++) {
			ch = player.charAt(i);

			if(trv.next[ch - 'a'] == null) {
				temp = new TrieNode(ch, false);
				trv.next[ch - 'a'] = temp;
				trv = trv.next[ch - 'a'];
			} else {
				trv = trv.next[ch - 'a'];
			}
		}
		trv.isLeaf = true;
	}
}
