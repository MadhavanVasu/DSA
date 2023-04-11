package LeetCode.Easy;

public class LongestBalancedSubstring {

    public int findTheLongestBalancedSubstring(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        int maxLength = 0;
        for (Character x : s.toCharArray()) {
            if (x == '0') {
                if (oneCount != 0) {
                    zeroCount = 0;
                    oneCount = 0;
                }
                zeroCount++;
            } else {
                oneCount++;
                if (maxLength < Math.min(zeroCount, oneCount) * 2)
                    maxLength = Math.min(zeroCount, oneCount) * 2;
            }
        }
        return maxLength;
    }

}
