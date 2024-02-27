package LeetCode.Contest.Weekly381;

public class MinimumNumberOfPushesWord1 {

    public int minimumPushes(String word) {
        int len = word.length();
        int count = 1;
        int result = 0;
        while (true) {
            if (len < 8) {
                result += (len * count);
                break;
            } else {
                result += (8 * count);
                len -= 8;
            }
            count++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
