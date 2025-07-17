package target2024.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
public class TopologicalSort {
	public static void main(String[] args) {
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
		Map<Character, List<Character>> adjList = new HashMap<>();
		Set<Character> charSet = new HashSet<>();

		//Total characters
		for(String str: dict) {
			for(Character ch: str.toCharArray()) {
				charSet.add(ch);
			}
		}

		//Initializing the adjacency list
		for(Character ch: charSet) {
			adjList.put(ch, new LinkedList<>());
		}

		//Creating the adjList
		for(int i=0; i<dict.length - 1; i++) {
			String str1 = dict[i];
			String str2 = dict[i+1];
			for(int j=0; j<str1.length() && j<str2.length(); j++) {
				char ch1 = str1.charAt(j);
				char ch2 = str2.charAt(j);
				if(ch1 != ch2) {
					List<Character> tlist = adjList.get(ch1);
					tlist.add(ch2);
					adjList.put(ch1, tlist);
					break;
				}
			}
		}

		//Printing the adjacency list
		adjList.forEach((k, v) -> {
			System.out.println(k + " --> " + v);
		});

		//Begin topological sort
		Set<Character> visited = new HashSet<>();
		Stack<Character> stack = new Stack<>();

		for(Character ch: charSet) {
			topologicalSort(ch, visited, stack, adjList);
		}

		System.out.println("Popping the stack");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " -->");
		}

	}

	private static void topologicalSort(Character ch, Set<Character> visited,
										Stack<Character> stack, Map<Character, List<Character>> adjList) {
		if(visited.contains(ch)) {
			return;
		}
		visited.add(ch);

		for(Character ach: adjList.get(ch)) {
			topologicalSort(ach, visited, stack, adjList);
		}
		stack.push(ch);
	}
}
