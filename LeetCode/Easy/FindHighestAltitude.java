package LeetCode.Easy;

public class FindHighestAltitude {

    public int largestAltitude(int[] gain) {

        int max = 0;
        int curr = 0;
        for (int x : gain) {
            curr += x;
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}


