package LeetCode.Medium;

public class SeparateBlackAndWhiteBalls {

    public long minimumSteps(String s) {
        int blackBallCounts = 0;
        long operations = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                blackBallCounts++;
            else
                operations += (blackBallCounts);
        }
        return operations;
    }

    public static void main(String[] args) {

    }

}
