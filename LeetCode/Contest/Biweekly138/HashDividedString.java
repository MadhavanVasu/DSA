package LeetCode.Contest.Biweekly138;

public class HashDividedString {

    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += (s.charAt(j) - '0');
            }
            int rem = sum % 26;
            result.append(rem).append("a");
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }

}
