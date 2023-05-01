package LeetCode.Easy;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skippedS = 0;
        int skippedT = 0;
        while (true) {
            if (i <= -1 && j <= -1) return true;
            if (i >= 0 && s.charAt(i) == '#') {
                i--;
                skippedS++;
            } else if (j >= 0 && t.charAt(j) == '#') {
                j--;
                skippedT++;
            } else if (skippedS != 0) {
                i -= skippedS;
                skippedS = 0;
            } else if (skippedT != 0) {
                j -= skippedT;
                skippedT = 0;
            } else {
                if (i >= 0 && j >= 0) {
                    if (s.charAt(i) != t.charAt(j))
                        return false;
                    i--;
                    j--;
                } else return false;
            }
        }
    }
}
