package LeetCode.Easy;

public class SqrtX {

    public static int mySqrtBinarySearch(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid)
                return mid;
            else if (x / mid < mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left - 1;
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int res = 1;
        int i = 1;
        int num = 1;
        while (true) {
            if (num > x)
                return res - 1;
            else if (i == x)
                return res;
            i += 2;
            num += i;
            res++;
        }
    }

    public static void main(String[] args) {

        int x = 9;
        System.out.println(mySqrt(x));

    }

}
