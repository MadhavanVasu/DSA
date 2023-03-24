package LeetCode.Easy;

public class NthTriboNum {
    public static int tribonacci(int n) {
        int t1 = -1;
        int t2 = 1;
        int t3 = 0;
        int res = 0;
        for(int i=0; i<n+1; i++)
        {
            res = t1+t2+t3;
            t1 = t2;
            t2 = t3;
            t3 = res;
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(tribonacci(n));

    }
}
