package LeetCode.Contest.Contest361;

public class CountSymmetricIntegers {

    public int countSymmetricIntegers(int low, int high) {

        int i = low;
        int res = 0;
        while (i <= high) {
            int power = (int) Math.log10(i);
            if (power % 2 == 0) {
                i = (int) Math.pow(10, power + (double) 1);
            } else {
                int temp = i;
                int j = 0;
                int sum1 = 0;
                int sum2 = 0;
                while (temp != 0) {
                    if (j <= power / 2) {
                        sum1 += temp % 10;
                    } else {
                        sum2 += temp % 10;
                    }
                    j++;
                    temp = temp / 10;
                }
                if (sum1 == sum2) res++;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
