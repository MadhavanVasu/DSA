package LeetCode.Contest.Weekly411;

public class CountSubstringsThatSatisfyKCondition1 {

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] counter = new int[2];
            for (int j = i; j < n; j++) {
                counter[s.charAt(j) - '0']++;
                if (counter[0] <= k || counter[1] <= k) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
