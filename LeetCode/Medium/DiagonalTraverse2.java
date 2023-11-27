package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse2 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int m = 0;
        int count = 0;
        for (List<Integer> row : nums) {
            if (row.size() > m) m = row.size();
            count += row.size();
        }
        int[] result = new int[count];
        List<List<Integer>> tempResult = new ArrayList<>();
        int maxLength = Math.max(n, m);
        for (int i = 0; i < maxLength + maxLength - 1; i++) {
            tempResult.add(new ArrayList<>());
        }
        int k = 0;
        for (List<Integer> num : nums) {
            int j = 0;
            while (j < num.size()) {
                tempResult.get(j + k).add(num.get(j));
                j++;
            }
            k++;
        }
        int i = 0;
        for (List<Integer> row : tempResult) {
            for (int j = row.size() - 1; j >= 0; j--)
                result[i++] = row.get(j);
        }
        return result;
    }

    public static void main(String[] args) {


    }

}
