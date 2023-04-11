package LeetCode.Hard;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int n = s1.length();
        if (n == 1)
            return false;
        String s = s1 + " " + s2;
        if (map.containsKey(s))
            return map.get(s);
        map.put(s, true);
        for (int i = 1; i < n; i++) {
            boolean res = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));
            if (res)
                return true;
            res = isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i));
            if (res) return true;
        }
        map.put(s, false);
        return map.get(s);
    }

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("great", "rgeat"));

    }

}
