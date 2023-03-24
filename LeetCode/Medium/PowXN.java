package LeetCode.Medium;

public class PowXN {

    public static double helper(double x, int n) {
        if (n == 1)
            return x;
        double temp = helper(x, n / 2);
        if (n % 2 == 0)
            return temp * temp;
        else
            return temp * temp * x;
    }

    public static double myPow(double x, int n) {

        if (x == 1)
            return x;
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -(n);
            x = 1 / x;
        }
        if (n < 0) {
            if(x==-1)
                return -x;
            n = -(n + 1);
        }
        System.out.println(n + " " + x);
        if(n%2!=0 && x==-1)
            return x;
        else if(n%2==0 && x==1)
            return -x;
        return helper(x, n);
    }

    public static void main(String[] args) {
        double x = -1.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));

    }

}
