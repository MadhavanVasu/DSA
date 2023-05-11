package LeetCode.Contest.Weekly344;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {

    Map<Integer, Integer> map;
    Map<Integer, Integer> frequencyMap;

    public FrequencyTracker() {
        map = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public void add(int number) {
        int prevFreq = map.getOrDefault(number, 0);
        if (prevFreq != 0) {
            frequencyMap.put(prevFreq, frequencyMap.get(prevFreq) - 1);
            if (frequencyMap.get(prevFreq) <= 0)
                frequencyMap.remove(prevFreq);
        }
        map.put(number, map.getOrDefault(number, 0) + 1);
        frequencyMap.put(map.get(number), frequencyMap.getOrDefault(map.get(number), 0) + 1);
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            frequencyMap.put(map.get(number), frequencyMap.get(map.get(number)) - 1);
            if (frequencyMap.get(map.get(number)) <= 0) frequencyMap.remove(map.get(number));
            map.put(number, map.get(number) - 1);
            if (map.get(number) == 0)
                map.remove(number);
            if (map.containsKey(number))
                frequencyMap.put(map.get(number), frequencyMap.getOrDefault(map.get(number), 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return frequencyMap.containsKey(frequency) && frequencyMap.get(frequency) != 0;
    }

    public static void main(String[] args) {

        String[] commands = {"FrequencyTracker", "add", "add", "deleteOne", "deleteOne", "deleteOne", "hasFrequency"};
        Integer[] values = {null, 5, 4, 6, 4, 7, 1};
        FrequencyTracker frequencyTracker = null;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("FrequencyTracker")) frequencyTracker = new FrequencyTracker();
            else if (commands[i].equals("add")) frequencyTracker.add(values[i]);
            else if (commands[i].equals("deleteOne")) frequencyTracker.deleteOne(values[i]);
            else System.out.println(frequencyTracker.hasFrequency(values[i]));
        }
    }
}