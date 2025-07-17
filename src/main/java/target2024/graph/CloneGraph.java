package target2024.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/clone-graph/?envType=study-plan-v2&envId=top-interview-150
class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {
	public static void main(String[] args) {
		CloneGraph cg = new CloneGraph();
		Node ogNode1 = new Node(1);
		Node ogNode2 = new Node(2);
		Node ogNode3 = new Node(3);
		Node ogNode4 = new Node(4);

		ogNode1.neighbors = new ArrayList<>(Arrays.asList(ogNode2, ogNode4));
		ogNode2.neighbors = new ArrayList<>(Arrays.asList(ogNode1, ogNode3));
		ogNode3.neighbors = new ArrayList<>(Arrays.asList(ogNode2, ogNode4));
		ogNode4.neighbors = new ArrayList<>(Arrays.asList(ogNode1, ogNode3));

		Node clonedNode1 = cg.cloneGraph(ogNode1);

		Set<Integer> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(clonedNode1);

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(visited.contains(node.val)) {
				//Do nothing
			} else {
				visited.add(node.val);
				System.out.print(node.val + " --> ");
				node.neighbors.forEach(neighbourNode -> {
					System.out.print(neighbourNode.val + " ");
					queue.add(neighbourNode);
				});
				System.out.println();
			}
		}

	}

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		Map<Integer, Node> nodeMap = new HashMap<>();

		//BFS the node and store the new node in hashmap
		//Create the nodes first
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node qNode = queue.poll();
			if (nodeMap.get(qNode.val) != null) {
				//Do nothing
			} else {
				Node newNode = new Node(qNode.val);
				nodeMap.put(qNode.val, newNode);

				//Iterate through the neighbour list
				qNode.neighbors.forEach(neighbourNode -> {
					queue.add(neighbourNode);
				});
			}
		}

		//Building the list of neighbours
		//BFS again
		Queue<Node> qq = new LinkedList<>();
		qq.add(node);
		while (!qq.isEmpty()) {
			Node qqNode = qq.poll();
			if(nodeMap.get(qqNode.val).neighbors.isEmpty()) {
				Node cqNode = nodeMap.get(qqNode.val);
				qqNode.neighbors.forEach(neighbourNode -> {
					cqNode.neighbors.add(nodeMap.get(neighbourNode.val));
					qq.add(neighbourNode);
				});
			} else {
				//Do nothing
			}
		}
		return nodeMap.get(node.val);
	}
}

