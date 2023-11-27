package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list;
            if (groupMap.containsKey(groupSizes[i]))
                list = groupMap.get(groupSizes[i]);
            else
                list = new ArrayList<>();
            list.add(i);
            groupMap.put(groupSizes[i], list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int key : groupMap.keySet()) {
            for (int i = 0; i < groupMap.get(key).size(); i += key) {
                List<Integer> list = new ArrayList<>();
                int j = i;
                while (j < key) {
                    list.add(groupMap.get(key).get(j));
                }
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
