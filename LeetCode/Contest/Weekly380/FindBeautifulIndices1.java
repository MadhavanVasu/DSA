package LeetCode.Contest.Weekly380;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndices1 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < s.length() - (a.length() - 1); i++) {
            boolean flag = true;
            for (int j = i; j < i + a.length(); j++) {
                if (s.charAt(j) != a.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) aIndices.add(i);
        }
        for (int i = 0; i < s.length() - (b.length() - 1); i++) {
            boolean flag = true;
            for (int j = i; j < i + b.length(); j++) {
                if (s.charAt(j) != b.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) bIndices.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int x : aIndices) {
            for (int y : bIndices) {
                int diff = Math.abs(x - y);
                if (diff <= k) {
                    result.add(x);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindBeautifulIndices1().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
    }

}
