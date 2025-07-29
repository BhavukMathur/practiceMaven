package target2024.graph;

import java.util.*;

public class RobotDeliveryPaths {

    public static void main(String[] args) {
        List<String[]> paths = Arrays.asList(
            new String[]{"B", "K"},
            new String[]{"C", "K"},
            new String[]{"E", "L"},
            new String[]{"F", "G"},
            new String[]{"J", "M"},
            new String[]{"E", "F"},
            new String[]{"C", "G"},
            new String[]{"A", "B"},
            new String[]{"A", "C"},
            new String[]{"G", "H"},
            new String[]{"G", "I"}
        );

        Map<String, Set<String>> result = findStartToEndPaths(paths);

        // Output result
//        for (String start : result.keySet()) {
//            System.out.println(start + ": " + result.get(start));
//        }
    }
    
    public static Map<String, Set<String>> findStartToEndPaths(List<String[]> paths) {
    	Map<String, List<String>> adjList = new HashMap();
    	Set<String> sourceNodes = new HashSet();
    	Set<String> destNodes = new HashSet();
    	
    	for(String[] path: paths) {
    		sourceNodes.add(path[0]);
    		destNodes.add(path[1]);
    		
    		//TODO: Form adjList
    	}
    	
    	//Iterate again and remove nodes
    	Set<String> sourceNodes2 = new HashSet(sourceNodes);
    	
    	sourceNodes.removeAll(destNodes);
    	destNodes.removeAll(sourceNodes2);
    	
    	System.out.println("Source Nodes : " + sourceNodes);
    	System.out.println("Dest Nodes : " + destNodes);
    	
    	//For each start node, perform dfs
    	Map<String, Set<String>> result = new HashMap<>();
    	
    	for(String str: sourceNodes) {
    		Set<String> destSet = new HashSet<>();
    		dfs(str, adjList, destSet);
    		result.put(str, destSet);
    	}
    	
    	return result;
    }
    
    private static void dfs(String node, Map<String, List<String>> adjList, Set<String> destSet) {
        if (!adjList.containsKey(node)) {
            // Leaf node
            destSet.add(node);
            return;
        }
        for (String neighbor : adjList.get(node)) {
            dfs(neighbor, adjList, destSet);
        }
    }
}
