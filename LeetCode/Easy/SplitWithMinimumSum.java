package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitWithMinimumSum {

    public int splitNum(int num) {
        List<Integer> arr = new ArrayList<>();
        while (num > 0) {
            arr.add(num % 10);
            num = num / 10;
        }
        Collections.sort(arr);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0)
                num1 = num1 * 10 + arr.get(i);
            else
                num2 = num2 * 10 + arr.get(i);
        }
        return num1 + num2;
    }

    public static void main(String[] args) {

    }

}
