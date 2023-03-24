package CodingNinjas.Easy;


public class FindNthRoot {

    public static double findNthRootOfM(int n, int m) {
        double left = 1;
        double right = m;
        double eps = 1e-6;
        while (right - left > eps) {
            double mid = left + (right - left) / 2;
            if (Math.pow(mid, n) < m)
                left = mid;
            else
                right = mid;
        }
        return Math.floor(right * 1000000) / 1000000;
    }

    public static void main(String[] args) {
        System.out.println(findNthRootOfM(4, 69));
        System.out.println(Math.pow(2.882121, 4));

    }

}
