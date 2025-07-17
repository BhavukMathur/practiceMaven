package target2024.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphMain {
	public static void main(String[] args) {
		//Adjacency matrix
		//Adjacency list
		//BFS and DFS
		List<List<Integer>> adjList = new ArrayList();
		int nodeNum = 5;

		for(int i=0; i<nodeNum; i++) {
			adjList.add(new ArrayList<>());
		}

		insertAdjList(adjList, 0, 1);
		insertAdjList(adjList, 0, 4);
		insertAdjList(adjList, 1, 2);
		insertAdjList(adjList, 1, 3);
		insertAdjList(adjList, 1, 4);
		insertAdjList(adjList, 2, 3);
		insertAdjList(adjList, 3, 4);

		adjList.forEach(nodeList -> {
			nodeList.forEach(node -> {
				System.out.print(node + " ");
			});
			System.out.println();
		});

		//BFS traversal of the graph
		System.out.println("\nBFS Traversal");
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited.add(1);
		bfs(queue, visited, adjList);

		//DFS traversal of the graph
		System.out.println("\nDFS Traversal");
		Stack<Integer> stack = new Stack<>();
		visited.clear();
		stack.add(0);
		visited.add(0);
		dfs(stack, visited, adjList);
	}

	private static void dfs(Stack<Integer> stack, Set<Integer> visited, List<List<Integer>> adjList) {
		int node;
		while(!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node + "--> ");

			for(int child: adjList.get(node)) {
				if(!visited.contains(child)) {
					visited.add(child);
					stack.push(child);
				}
			}
		}
	}

	private static void bfs(Queue<Integer> queue, Set<Integer> visited, List<List<Integer>> adjList) {
		int node;
		while(!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node + "--> ");

			for (int child: adjList.get(node)) {
				if(!visited.contains(child)) {
					visited.add(child);
					queue.add(child);
				}
			}
		}
	}

	private static void insertAdjList(List<List<Integer>> adjList, int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
}
