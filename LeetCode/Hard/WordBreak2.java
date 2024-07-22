package LeetCode.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    public void helper(int i, String s, int n, Set<String> wordDict, List<String> result, List<String> curr) {
        if (i == n) {
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < curr.size(); j++) {
                if (j != curr.size() - 1) res.append(curr.get(j) + " ");
                else res.append(curr.get(j));
            }
            result.add(res.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < n; j++) {
            sb.append(s.charAt(j));
            String temp = sb.toString();
            if (wordDict.contains(temp)) {
                curr.add(temp);
                helper(j + 1, s, n, wordDict, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        helper(0, s, s.length(), dict, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {

    }

}
