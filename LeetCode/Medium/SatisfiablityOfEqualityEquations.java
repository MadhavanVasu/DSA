package LeetCode.Medium;

import java.util.*;

public class SatisfiablityOfEqualityEquations {
    public boolean bfs(char x, char y, Map<Character, List<Character>> adjacencyMap) {
        if (x == y) return false;
        if (!adjacencyMap.containsKey(x) || !adjacencyMap.containsKey(y)) return true;
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        visited.add(x);
        queue.add(x);
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (char adj : adjacencyMap.get(c)) {
                if (adj == y) return false;
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, List<Character>> adjacencyMap = new HashMap<>();
        List<String> inequalities = new ArrayList<>();
        for (String x : equations) {
            if (x.substring(1, 3).equals("==")) {
                if (x.charAt(0) == x.charAt(3)) continue;
                List<Character> adjacent = adjacencyMap.getOrDefault(x.charAt(0), new ArrayList<>());
                adjacent.add(x.charAt(3));
                adjacencyMap.put(x.charAt(0), adjacent);
                adjacent = adjacencyMap.getOrDefault(x.charAt(3), new ArrayList<>());
                adjacent.add(x.charAt(0));
                adjacencyMap.put(x.charAt(3), adjacent);
            } else inequalities.add(x);
        }
        for (String x : inequalities) {
            if (!bfs(x.charAt(0), x.charAt(3), adjacencyMap)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
