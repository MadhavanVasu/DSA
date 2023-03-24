package LeetCode.Easy;

public class NumberOfValidClockTimes {

    public int countTime(String time) {
        int count = 1;
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        if (m2 == '?') count *= 10;
        if (m1 == '?') count *= 6;
        if (h1 == '?' && h2 == '?') count *= (24);
        else if (h1 == '?') {
            if (Integer.parseInt(String.valueOf(h2)) <= 3) count *= 3;
            else count *= 2;
        } else if (h2 == '?') {
            if (h1 == '2') count *= 4;
            else count *= 10;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
