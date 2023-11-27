package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int currElementInStream = 1;
        for (int x : target) {
            if (x == currElementInStream) {
                result.add("Push");
            } else {
                while (currElementInStream != x) {
                    result.add("Push");
                    result.add("Pop");
                    currElementInStream++;
                }
                result.add("Push");
            }
            currElementInStream++;
            if (currElementInStream > n) currElementInStream = 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
