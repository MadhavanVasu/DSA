package LeetCode.Contest.Weekly392;

public class LexicographicallySmallestStringWithOperations {

    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        if (k == 0) return s;
        int i = 0;
        while (k > 0 && i < s.length()) {
            char c = s.charAt(i);
            if (c == 'a') {
                sb.append('a');
                i++;
                continue;
            }
            int op1 = c - 97;
            int op2 = 26 - (c - 97);
            if (op1 < op2 && op1 <= k) {
                sb.append('a');
                k -= op1;
            } else if (op2 <= k) {
                sb.append('a');
                k -= op2;
            } else {
                sb.append((char) (c - k));
                k = 0;
            }
            i++;
        }
        while (i < s.length()) sb.append(s.charAt(i++));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicallySmallestStringWithOperations().getSmallestString("zbbz", 3));

    }

}
