package LeetCode.Easy;

public class MakeThreeStringsEqual {

    public int findMinimumOperations(String s1, String s2, String s3) {
        int i;
        for (i = 0; i < Math.min(Math.min(s1.length(), s2.length()), s3.length()); i++) {
            if (!(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))) break;
        }
        if (i == 0) return -1;
        return (s1.length() - i) + (s2.length() - i) + (s3.length() - i);
    }

    public static void main(String[] args) {

    }

}
