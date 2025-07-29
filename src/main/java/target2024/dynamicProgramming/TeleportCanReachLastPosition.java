package target2024.dynamicProgramming;

import java.util.*;

public class TeleportCanReachLastPosition {

    public static boolean canReachEnd(int startPosition, int lastNumber, int maxDieValue, List<String> teleporters) {
        Map<Integer, Integer> teleportMap = new HashMap<>();
        for (String teleporter : teleporters) {
            String[] parts = teleporter.split(",");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            teleportMap.put(from, to);
        }

        boolean[] dp = new boolean[lastNumber + 1];
        dp[startPosition] = true;

        for (int i = 0; i <= lastNumber; i++) {
            if (!dp[i]) continue;

            for (int roll = 1; roll <= maxDieValue; roll++) {
                int next = i + roll;
                if (next > lastNumber) {
                    next = lastNumber;
                }

                // Apply teleportation
                if (teleportMap.containsKey(next)) {
                    next = teleportMap.get(next);
                }

                dp[next] = true;
            }
        }

        return dp[lastNumber];
    }

    
    public static void main(String[] args) {
        int startPosition = 2;
        int lastNumber = 10;
        int maxDieValue = 6;
        List<String> teleporters = Arrays.asList("3,1", "5,10", "8,2");

        boolean result = canReachEnd(startPosition, lastNumber, maxDieValue, teleporters);
        System.out.println("Can reach last position (DP): " + result);
    }
}
