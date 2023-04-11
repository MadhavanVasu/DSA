package LeetCode.Medium;

import java.util.*;

public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Integer, Node> nodeMap = new HashMap<>();
            Node head = new Node(1);
            nodeMap.put(1, head);
            Set<Integer> visited = new HashSet<>();
            visited.add(1);
            Deque<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node v = queue.poll();
                Node newNode = nodeMap.get(v.val);
                for (Node x : v.neighbors) {
                    Node neighbor;
                    if (nodeMap.containsKey(x.val))
                        neighbor = nodeMap.get(x.val);
                    else {
                        neighbor = new Node(x.val);
                        nodeMap.put(x.val, neighbor);
                    }
                    newNode.neighbors.add(neighbor);
                    if (!visited.contains(x.val)) {
                        queue.addLast(x);
                        visited.add(x.val);
                    }
                }
            }
            return head;
        }
    }

}
