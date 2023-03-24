package LeetCode.Easy;

public class CountOddNumbers {

    public static int countOdds(int low, int high) {

        int n = high - low + 1;
        if(n%2==0 || (high%2==0 && low%2==0))
            return n/2;
        return n/2+1;

    }

    public static void main(String[] args) {

        int low = 3;
        int high = 8;
        System.out.println(countOdds(low,high));

    }

}
