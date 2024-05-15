package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    public class Trie {
        public class Node {
            Node[] alpha;
            int end;

            public Node() {
                alpha = new Node[26];
                for (int i = 0; i < 26; i++)
                    alpha[i] = null;
                end = 0;
            }
        }

        Node head;

        public Trie() {
            head = new Node();
        }

        public boolean insert(String word) {
            Node temp = head;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int pos = word.charAt(i) - 97;
                if (temp.alpha[pos] == null) {
                    if (i == 0) {
                        if (word.length() != 1)
                            return false;
                    } else if (i != n - 1)
                        return false;
                    temp.alpha[pos] = new Node();
                } else {
                    if (temp.alpha[pos].end != 1)
                        return false;
                }
                temp = temp.alpha[pos];
            }
            temp.end = 1;
            return true;
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();
        String result = "";
        for (String x : words) {
            boolean validString = trie.insert(x);
            if (validString) {
                if (x.length() > result.length())
                    result = x;
            }
        }
        return result;
    }

    public String longestWordWithoutTrie(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        for (String x : words) {
            boolean validString = true;
            if (x.length() == 1)
                set.add(x);
            else {
                String subStr = x.substring(0, x.length() - 1);
                if (!set.contains(subStr)) validString = false;
            }
            if (validString) {
                set.add(x);
                if (result.length() < x.length()) result = x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "apply", "apple", "ab", "abl", "abc", "ap"};
        LongestWordInDictionary obj = new LongestWordInDictionary();
        System.out.println(obj.longestWord(words));
    }

}
