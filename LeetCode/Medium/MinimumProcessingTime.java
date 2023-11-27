package LeetCode.Medium;

import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int timeTaken = 0;
        int task = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            int time = processorTime.get(i) + tasks.get(task);
            if (time > timeTaken) timeTaken = time;
            task += 4;
        }
        return timeTaken;
    }

    public static void main(String[] args) {

    }

}
