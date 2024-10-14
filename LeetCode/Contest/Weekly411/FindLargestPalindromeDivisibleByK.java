package LeetCode.Contest.Weekly411;

public class FindLargestPalindromeDivisibleByK {

    String result = "";

    public boolean helper(int i, int n, int k, String palindrome, int rem) {
        if ((i == n / 2 && n % 2 == 0) || (i > n / 2)) {
            int j = i - 1;
            if (n % 2 != 0) j--;
            StringBuilder sb = new StringBuilder(palindrome);

            while (j >= 0) {
                rem = ((rem * 10) + (palindrome.charAt(j) - '0')) % k;
                sb.append(palindrome.charAt(j));
                j--;
            }
            if (rem == 0) {
                result = sb.toString();
                return true;
            }
        } else {
            for (int j = 9; j >= 0; j--) {
                if (i == 0 && j == 0) return false;
                boolean res = helper(i + 1, n, k, palindrome + (char) ('0' + j), ((rem * 10) + j) % k);
                if (res == true) return true;
            }
        }
        return false;
    }

    public String largestPalindrome(int n, int k) {
        helper(0, n, k, "", 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindLargestPalindromeDivisibleByK().largestPalindrome(15, 4));

    }

}
