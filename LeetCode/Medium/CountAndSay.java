package LeetCode.Medium;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 0;
            }
            count += 1;
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

}
