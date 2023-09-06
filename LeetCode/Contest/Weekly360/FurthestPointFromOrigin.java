package LeetCode.Contest.Weekly360;

public class FurthestPointFromOrigin {

    public int furthestDistanceFromOrigin(String moves) {

        int dashCount = 0;
        int left = 0;
        int right = 0;
        for (Character c : moves.toCharArray()) {
            if (c == 'L') left++;
            else if (c == 'R') right++;
            else dashCount++;
        }
        int diff = Math.abs(left - right);
        return diff + dashCount;

    }

    public static void main(String[] args) {

    }

}
