package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {

    public static boolean palindromeCheck(String s) {
        int n = s.length();
        int i = 0;
        while (i < n / 2) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
            i++;
        }
        return true;
    }

    public static List<List<String>> helperFn(int i, String prev, String s, int n) {
        if (i == n - 1) {
            List<List<String>> res = new ArrayList<>();
            if (prev.equals("")) {
                List<String> list = Arrays.asList(s.substring(i));
                res.add(list);
            } else {
                String concatStr = prev.concat(s.substring(i));
                if (palindromeCheck(concatStr)) {
                    List<String> list = Arrays.asList(concatStr);
                    res.add(list);
                }
            }
            return res;
        }
        String concatStr = prev.concat(s.substring(i,i+1));
        List<List<String>> res1 = new ArrayList<>();
        if (palindromeCheck(concatStr)) {
            res1 = helperFn(i + 1, "", s, n);
        }
        List<List<String>> res2 = helperFn(i + 1, concatStr, s, n);
        List<List<String>> result = new ArrayList<>();
        if (!res1.isEmpty()) {
            for (List<String> x : res1) {
                List<String> temp = new ArrayList<>(x);
                temp.add(concatStr);
                result.add(temp);
            }
        }
        if (!res2.isEmpty()) {
            result.addAll(res2);
        }
        return result;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result =  helperFn(0, "", s, s.length());
        for(List<String> x : result)
            Collections.reverse(x);
        return result;
    }

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(partition(s));

    }

}
