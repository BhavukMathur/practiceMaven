package target2024.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoardTeleport {

    public static Set<Integer> findFinalPositions(int startPosition, int lastNumber, int maxDieValue, List<String> teleporters) {
        // Map for teleport lookup
        Map<Integer, Integer> teleportMap = new HashMap<>();
        for (String teleporter : teleporters) {
            String[] parts = teleporter.split(",");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            teleportMap.put(from, to);
        }

        Set<Integer> finalPositions = new HashSet<>();

        for (int roll = 1; roll <= maxDieValue; roll++) {
            int nextPos = startPosition + roll;
            if (nextPos > lastNumber) {
                nextPos = lastNumber;
            }
            // Apply teleport if exists
            if (teleportMap.containsKey(nextPos)) {
                nextPos = teleportMap.get(nextPos);
            }
            finalPositions.add(nextPos);
        }

        return finalPositions;
    }

    public static void main(String[] args) {
        int startPosition = 0;
        int lastNumber = 10;
        int maxDieValue = 6;
        List<String> teleporters = Arrays.asList("3,1", "5,10", "8,2");

        Set<Integer> result = findFinalPositions(startPosition, lastNumber, maxDieValue, teleporters);
        System.out.println("Final reachable positions after one roll: " + result);
    }
}
