package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrimeInDiagonal {

    public static int diagonalPrime(int[][] nums) {

        List<Integer> diagonalNums = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            diagonalNums.add(nums[i][i]);
            if (i != n - i - 1)
                diagonalNums.add(nums[i][n - i - 1]);
        }
        Collections.sort(diagonalNums);
        int res = 0;
        for (int x : diagonalNums) {
            if (x <= 1)
                continue;
            else if (x == 2 || x == 3)
                res = x;
            else if (x % 2 == 0) continue;
            else {
                int f = 0;
                for (int i = 3; i <= Math.sqrt(x); i += 2) {
                    if (x % i == 0) {
                        f = 1;
                        break;
                    }
                }
                if (f != 1) res = x;
            }
        }
        return res;


    }

    public static void main(String[] args) {

        int[][] nums = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        System.out.println(diagonalPrime(nums));


    }

}
