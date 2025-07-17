package target2024.graph;

//https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.List;

/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 * Return all critical connections in the network in any order.
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CriticalConnections {
	private int timer = 0;  // Global timer used in DFS

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		// Initialize discovery and lowest arrays, and graph adjacency list
		int[] discovery = new int[n];
		int[] lowest = new int[n];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
			discovery[i] = -1;  // -1 signifies unvisited node
		}

		// Build the graph
		for (List<Integer> conn : connections) {
			int u = conn.get(0);
			int v = conn.get(1);
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		List<List<Integer>> bridges = new ArrayList<>();

		// Find bridges for components in graph
		for (int i = 0; i < n; i++) {
			if (discovery[i] == -1) {
				dfs(i, -1, discovery, lowest, adjList, bridges);
			}
		}

		return bridges;
	}

	private void dfs(int node, int parent, int[] discovery, int[] lowest, List<List<Integer>> adjList, List<List<Integer>> bridges) {
		discovery[node] = lowest[node] = timer++;
		for (int neighbor : adjList.get(node)) {
			if (neighbor == parent) continue;  // Skip the parent
			if (discovery[neighbor] == -1) {  // Not visited
				dfs(neighbor, node, discovery, lowest, adjList, bridges);
				lowest[node] = Math.min(lowest[node], lowest[neighbor]);
				// If the lowest vertex reachable from subtree under neighbor is above node in DFS tree
				if (lowest[neighbor] > discovery[node]) {
					bridges.add(Arrays.asList(node, neighbor));
				}
			} else {
				// Update the lowest value of node for parent function calls.
				lowest[node] = Math.min(lowest[node], discovery[neighbor]);
			}
		}
	}

	public static void main(String[] args) {
		CriticalConnections sol = new CriticalConnections();
		List<List<Integer>> connections = Arrays.asList(
				Arrays.asList(0, 1),
				Arrays.asList(1, 2),
				Arrays.asList(2, 0),
				Arrays.asList(1, 3)
		);
		int n = 4;
		List<List<Integer>> result = sol.criticalConnections(n, connections);
		for (List<Integer> bridge : result) {
			System.out.println(bridge);
		}
	}
}
