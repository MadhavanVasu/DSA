package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayTo2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            for (int i = 0; i < freqMap.get(key); i++) {
                if (result.size() < i + 1) {
                    result.add(new ArrayList<>());
                }
                result.get(i).add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
