package LeetCode.Medium;

import java.util.Collections;
import java.util.List;

public class CountMentionsPerUser {


    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        String OFFLINE_EVENT = "OFFLINE";
        String ALL_USERS = "ALL";
        String ONLINE_USERS = "HERE";
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 > t2) return 1;
            if (t1 < t2) return -1;
            if (a.get(0).equals(OFFLINE_EVENT)) return -1;
            if (b.get(0).equals(OFFLINE_EVENT)) return 1;
            return 0;
        });
        int[] offlineTime = new int[numberOfUsers];
        for (List<String> strings : events) {
            String event = strings.get(0);
            int timeStamp = Integer.parseInt(strings.get(1));
            if (event.equals(OFFLINE_EVENT)) {
                int userId = Integer.parseInt(strings.get(2));
                offlineTime[userId] += (timeStamp + 60);
            } else {
                String users = strings.get(2);
                if (users.equals(ALL_USERS)) {
                    for (int j = 0; j < numberOfUsers; j++) mentions[j]++;
                } else if (users.equals(ONLINE_USERS)) {
                    for (int j = 0; j < numberOfUsers; j++) {
                        if (timeStamp >= offlineTime[j]) {
                            offlineTime[j] = 0;
                            mentions[j]++;
                        }
                    }
                } else {
                    String[] usersMentioned = users.split("\\s+");
                    for (String user : usersMentioned) {
                        int userId = Integer.parseInt(user.substring(2));
                        if (timeStamp >= offlineTime[userId]) {
                            offlineTime[userId] = 0;
                            mentions[userId]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }

    public static void main(String[] args) {

    }

}
