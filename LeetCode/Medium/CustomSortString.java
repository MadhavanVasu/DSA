package LeetCode.Medium;

public class CustomSortString {

    public String customSortString(String order, String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) charFreq[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (charFreq[c - 'a']-- > 0)
                sb.append(c);
        }
        for (int i = 0; i < 26; i++) {
            while (charFreq[i]-- > 0)
                sb.append((char) ('a' + i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba", "abcd"));
    }

}
