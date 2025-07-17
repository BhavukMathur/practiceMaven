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
 * Given a graph where each node is a city starting from 1
 * Find the longest distance between two nodes
 * All nodes coming on the path between the two nodes are primary cities
 * All other nodes are secondary cities
 * Find sum of all secondary cities
 *		1 - 2
 * 	 /
 * 0  - 3
 * 	 \
 * 	 	4 - 5 - 6
 */
public class SecondaryCities {
	public static void main(String[] args) {
		int cityCount = 7;
		Set<Integer> cityHash = new HashSet<>();
		for(int i=0; i<cityCount; i++) {
			cityHash.add(i);
		}

		//Building the adjacency list
		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for(int i=0; i<cityCount; i++) {
			adjList.put(i, new LinkedList<>());
		}

		updateAdjacencyList(adjList, 0, 1);
		updateAdjacencyList(adjList, 0, 3);
		updateAdjacencyList(adjList, 0, 4);
		updateAdjacencyList(adjList, 1, 2);
		updateAdjacencyList(adjList, 4, 5);
		updateAdjacencyList(adjList, 5, 6);

		//Printing the adjacency list
		for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			System.out.print(entry.getKey() + " : ");
			entry.getValue().forEach(value -> {
				System.out.print(value + ", ");
			});
			System.out.println();
		}

		//Finding the diameter of the graph (two most distant nodes)
		//Find the farthest node from any node - say 0
		//Find the farthest node from that node
		int[] distance = bfs(adjList, 0);
		System.out.println(Arrays.toString(distance));
		int u = getMaxFromDistance(distance);
		System.out.println("Farthest node u = " + u);

		int[] distance2 = bfs(adjList, u);
		System.out.println(Arrays.toString(distance2));
		int v = getMaxFromDistance(distance2);
		System.out.println("Farthest node v = " + v);

		//After getting two farthest nodes u, v
		//Traverse the path between u and v and remove other nodes to get secondary cities

		Set<Integer> secondaryCities = new HashSet<>();
		for(int i=0; i<cityCount; i++) {
			secondaryCities.add(i);
		}

		//This is not working as not sure how to move from 0 towards the path.
		traversePathDFS(adjList, u, v, secondaryCities);
		System.out.println("Secondary cities");
		for(Integer city: secondaryCities) {
			System.out.print(city + " - ");
		}
	}

	private static void traversePathDFS(Map<Integer, List<Integer>> adjList, int u, int v, Set<Integer> secondaryCities) {
		Stack<Integer> stack = new Stack<>();
		stack.add(u);
		Set<Integer> visited = new HashSet<>();
		visited.add(u);
		secondaryCities.remove(u);
		secondaryCities.remove(v);

		while(!stack.isEmpty()) {
			int node = stack.pop();
			visited.add(node);
			if(node == v) {
				return;
			}
			secondaryCities.remove(node);
			List<Integer> list = adjList.get(node);
			for(Integer neighbour: list) {
				if(!visited.contains(neighbour)) {
					stack.push(neighbour);
				}
			}
		}
	}

	private static int getMaxFromDistance(int[] distance) {
		int maxDistance = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i=0; i<distance.length; i++) {
			if(distance[i] > maxDistance) {
				maxDistance = distance[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private static int[] bfs(Map<Integer, List<Integer>> adjList, int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		int[] distance = new int[adjList.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);

		queue.add(startNode);
		distance[startNode] = 0;
		visited.add(startNode);

		while(!queue.isEmpty()) {
			int node = queue.poll();
			List<Integer> list = adjList.get(node);
			for(Integer neighbour: list) {
				if(!visited.contains(neighbour)) {
					visited.add(neighbour);
					queue.add(neighbour);
					distance[neighbour] = distance[node] + 1;
				}
			}
		}

		return distance;
	}

	private static void updateAdjacencyList(Map<Integer, List<Integer>> adjList, int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
}
