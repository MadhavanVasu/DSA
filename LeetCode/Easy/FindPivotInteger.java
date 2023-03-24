package LeetCode.Easy;

public class FindPivotInteger {

    public static int pivotInteger(int n) {

        int sum = (n * (n + 1)) / 2;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum1 = (mid * (mid + 1)) / 2;
            int sum2 = sum - ((mid * (mid - 1)) / 2);
            if (sum1 == sum2)
                return mid;
            else if (sum1 < sum2) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(pivotInteger(49));

    }

}
