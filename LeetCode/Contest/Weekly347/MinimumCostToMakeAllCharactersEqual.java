package LeetCode.Contest.Weekly347;

public class MinimumCostToMakeAllCharactersEqual {

    public long minimumCost(String s) {

        int count = 1;
        int result = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                count++;
                prev = s.charAt(i);
                if (count == 3) {
                    result += 2;
                    count = 1;
                }
            }
        }
        if (count == 2) result++;
        return result;

    }

    public static void main(String[] args) {

    }

}
