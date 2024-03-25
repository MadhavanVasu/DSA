package LeetCode.Contest.Weekly387;

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArrays1 {

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int num : nums) {
            if (arr1.isEmpty()) arr1.add(num);
            else if (arr2.isEmpty()) arr2.add(num);
            else {
                if (arr1.get(arr1.size() - 1) > arr2.get(arr1.size() - 1)) arr1.add(num);
                else arr2.add(num);
            }
        }
        int i = 0;
        while (i < arr1.size()) {
            result[i] = arr1.get(i);
            i++;
        }
        i = 0;
        while (i < arr2.size()) {
            result[i + arr1.size()] = arr2.get(i);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
