package LeetCode.Medium;

import java.util.*;

public class OpenTheLock {
    public class QueueElement {
        String dialNumber;
        int moves;
        public QueueElement(String dialNumber) {
            this.dialNumber = dialNumber;
            this.moves = 0;
        }
        public QueueElement(String dialNumber, int moves) {
            this.dialNumber = dialNumber;
            this.moves = moves;
        }
    }

    public List<String> findNextPossibleNodes(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int digit = curr.charAt(i) - '0';
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                if (j != i) {
                    s1.append(curr.charAt(j));
                    s2.append(curr.charAt(j));
                } else {
                    if (digit + 1 > 9) s1.append('0');
                    else s1.append((char) ('0' + digit + 1));
                    if (digit - 1 < 0) s2.append('9');
                    else s2.append((char) ('0' + digit - 1));
                }
            }
            res.add(s1.toString());
            res.add(s2.toString());
        }
        return res;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deadEndsSet = new HashSet<>(List.of(deadends));
        if (deadEndsSet.contains("0000")) return -1;
        Queue<QueueElement> q = new LinkedList<>();
        q.add(new QueueElement("0000"));
        visited.add("0000");
        while (!q.isEmpty()) {
            QueueElement ele = q.poll();
            if (ele.dialNumber.equals(target)) return ele.moves;
            for (String s : findNextPossibleNodes(ele.dialNumber)) {
                if (!visited.contains(s) && !deadEndsSet.contains(s)) {
                    visited.add(s);
                    q.add(new QueueElement(s, ele.moves + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
