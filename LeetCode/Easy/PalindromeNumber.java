package LeetCode.Easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        double rev = 0;
        int actual = x;
        while (x != 0) {
            int rem = x % 10;
            rev = rev * 10 + rem;
            x /= 10;
        }
        return rev == actual;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

}
