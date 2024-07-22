package LeetCode.Medium;

public class GetEqualSubstringsWithinBudget {

    // Sliding Window Problem
    public int equalSubstring(String s, String t, int maxCost) {
        int start = -1;
        int result = 0;
        int i = 0;
        int currCost = 0;
        while (i < s.length()) {
            int cost = Math.abs(s.charAt(i) - t.charAt(i));
            if (currCost + cost > maxCost) {
                if (start != -1) {
                    result = Math.max(result, i - start);
                    if (cost > maxCost) {
                        start = -1;
                        currCost = 0;
                    } else {
                        currCost += cost;
                        while (currCost <= maxCost) {
                            int temp = Math.abs(s.charAt(i) - t.charAt(i));
                            currCost -= temp;
                            start++;
                        }
                    }
                }
            } else {
                currCost += cost;
                if (start == -1) start = i;
            }
            i++;
        }
        if (start != -1) {
            result = Math.max(result, i - start);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
