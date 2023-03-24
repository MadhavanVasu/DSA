package LeetCode.Easy;

import java.util.Arrays;

public class OddStringDifference {

    public static String oddString(String[] words) {
        int m = words[0].length();
        int[] diff1 = new int[m - 1];
        int diff1Count = 0;
        int diff2Count = 0;
        String string1 = "";
        String string2 = "";
        for (String x : words) {
            int[] tempDiff = new int[m - 1];
            for (int i = 1; i < m; i++) {
                int diff = (x.charAt(i) - 'a') - (x.charAt(i - 1) - 'a');
                tempDiff[i - 1] = diff;
            }
            if (diff1Count == 0) {
                diff1 = tempDiff;
                diff1Count++;
                string1 = x;
            } else if (Arrays.equals(diff1, tempDiff))
                diff1Count++;
            else {
                diff2Count++;
                string2 = x;
            }
            if (diff1Count != 0 && diff2Count != 0) {
                if (diff1Count > diff2Count)
                    return string2;
                else if(diff2Count>diff1Count)
                    return string1;
            }
        }
        return "";

    }

    public static void main(String[] args) {
        String[] words = {"aaa","bob","ccc","ddd"};
        System.out.println(oddString(words));

    }

}
