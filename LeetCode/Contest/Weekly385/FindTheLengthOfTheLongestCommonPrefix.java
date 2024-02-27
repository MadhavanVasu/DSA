package LeetCode.Contest.Weekly385;

public class FindTheLengthOfTheLongestCommonPrefix {

    public class Trie {

        class Node {
            Node[] nextNode;
            boolean end;

            public Node() {
                nextNode = new Node[10];
                end = false;
            }
        }

        Node head;

        public Trie() {
            head = new Node();
        }

        public void addNum(int num) {
            String s = Integer.toString(num);
            Node next = head;
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (next.nextNode[digit] == null) next.nextNode[digit] = new Node();
                next = next.nextNode[digit];
            }
            next.end = true;
        }

        public int findLongestCommonPrefix(int num) {
            int len = 0;
            String s = Integer.toString(num);
            Node next = head;
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (next.nextNode[digit] == null) break;
                len++;
                next = next.nextNode[digit];
            }
            return len;
        }

    }

    public int longestCommonPrefixUsingTrie(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for (int num : arr1) trie.addNum(num);
        int max = 0;
        for (int num : arr2) max = Math.max(max, trie.findLongestCommonPrefix(num));
        return max;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int result = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                int currPrefixLength = 0;
                String x = Integer.toString(i);
                String y = Integer.toString(j);
                if (i > j) {
                    x = Integer.toString(j);
                    y = Integer.toString(i);
                }
                for (int k = 0; k < x.length(); k++) {
                    if (x.charAt(k) != y.charAt(k)) break;
                    currPrefixLength++;
                }
                if (currPrefixLength > result) result = currPrefixLength;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
