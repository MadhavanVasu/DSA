package LeetCode.Contest.Weekly393;

public class LatestTimeYouCanObtainReplacingCharacters {

    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (s.charAt(i) == '?') {
                if (i == 0) {
                    if (s.charAt(1) == '?' || s.charAt(1) == '0' || s.charAt(1) == '1') sb.append('1');
                    else sb.append('0');
                } else if (i == 1) {
                    if (sb.charAt(0) == '1') sb.append('1');
                    else sb.append('9');
                } else if (i == 3) sb.append('5');
                else sb.append('9');
            } else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
