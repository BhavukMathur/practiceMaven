package target2024.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * [
	    {
	        "name": "A",
	        "dependencies": [
	            "B",
	            "C"
	        ]
	    },
	    {
	        "name": "B",
	        "dependencies": [
	            "C",
	            "D"
	        ]
	    },
	    {
	        "name": "C",
	        "dependencies": [
	            "D"
	        ]
	    },
	    {
	        "name": "D",
	        "dependencies": []
	    }
	]
	
	[] 

set-D --> print C --> print B --> print A
		
 */

public class Dependencies {

	public static void main(String[] args) {
		Map<Character, List<Character>> adjList = new HashMap<>();
		//D --> C --> B --> A
		
		adjList.put('A', Arrays.asList('B', 'C'));
		adjList.put('B', Arrays.asList('C', 'D'));
		adjList.put('C', Arrays.asList('D'));
		adjList.put('D', new LinkedList<>());
		
		printHeirarchy(adjList);
		
	}
	
	private static void printHeirarchy(Map<Character, List<Character>> adjList) {
		Set<Character> visited = new HashSet<>();
		Queue<Character> queue = new LinkedList<>();
		
		//Perform DFS
		for(Character ch: adjList.keySet()) {
			if(!visited.contains(ch)) {
				dfs(ch, adjList, visited, queue);
			}
		}
		
		//Empty the stack
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + "--> ");
		}
	}
	
	
	private static void dfs(
			Character ch, Map<Character, List<Character>> adjList, Set<Character> visited, Queue<Character> queue
		) {
		//Add to the visited set
		visited.add(ch);
		
		//Explore neighbours
		//Recursion is taking care of stack logic
		//Use a stack otherwise
		for(Character val: adjList.get(ch)) {
			if(!visited.contains(val)) {
				dfs(val, adjList, visited, queue);
			}
		}
		
		//Add to the stack
		queue.add(ch);
	}

}
