package LeetCode.Contest.Weekly416;

import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for (String x : bannedWords) set.add(x);
        int count = 0;
        for (String x : message) {
            if (set.contains(x)) count++;
            if (count >= 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
