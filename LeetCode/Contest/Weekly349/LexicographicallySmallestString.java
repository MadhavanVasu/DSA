package LeetCode.Contest.Weekly349;

public class LexicographicallySmallestString {

    public String smallestString(String s) {

        int start = -1;
        int end = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a') {
                if (start == -1) start = i;
            } else {
                if (start != -1) {
                    end = i - 1;
                    break;
                }
            }
        }
        if (start != -1 && end == -1) end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        if (start == -1 && end == -1) {
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1) sb.append("z");
                else sb.append(s.charAt(i));
            }
            return sb.toString();
        }
        for (int i = 0; i < s.length(); i++) {
            if (i >= start && i <= end) {
                char c = (char) (s.charAt(i) - 1);
                sb.append(c);
            } else
                sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(new LexicographicallySmallestString().smallestString("cbabc"));
        System.out.println(new LexicographicallySmallestString().smallestString("acbbc"));
        System.out.println(new LexicographicallySmallestString().smallestString("leetcode"));

    }

}
