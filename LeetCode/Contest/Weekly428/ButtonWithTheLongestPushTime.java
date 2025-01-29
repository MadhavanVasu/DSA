package LeetCode.Contest.Weekly428;

public class ButtonWithTheLongestPushTime {

    public int buttonWithLongestTime(int[][] events) {
        int result = 0;
        int max = 0;
        int currTime = 0;
        for (int[] event : events) {
            int timeTaken = event[1] - currTime;
            if (timeTaken > max) {
                max = timeTaken;
                result = event[0];
            }
            if (timeTaken == max) {
                if (result > event[0]) result = event[0];
            }
            currTime = event[1];
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
