package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueNoOfOccurence {

    public boolean uniqueOccurrences(int[] arr) {

        Set<Integer> countSet = new HashSet<>();
        Arrays.sort(arr);
        int prev = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]==prev)
                count++;
            else
            {
                if(countSet.contains(count))
                    return false;
                countSet.add(count);
                count = 1;
                prev = arr[i];
            }
        }
        return !countSet.contains(count);
    }

    public static void main(String[] args) {

    }

}
