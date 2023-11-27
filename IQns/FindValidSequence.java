package IQns;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class FindValidSequence {
    public char[] validSequences(int n, String[][] messages) {
        char[] result = {0};
        Comparator<String[]> customComparator = (a, b) -> {
            if (Long.parseLong(a[0]) < Long.parseLong(b[0])) return -1;
            else if (Long.parseLong(a[0]) > Long.parseLong(b[0])) return 1;
            return 0;
        };
        Arrays.sort(messages, customComparator);
        int sequenceStart = -1;
        long next = -1;
        for (int i = 0; i < n; i++) {
            if (messages[i][1].equals("*")) {
                if (sequenceStart != -1) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = sequenceStart + 1; j < i; j++) {
                        sb.append(messages[j][1].charAt(0));
                    }
                    if (!sb.toString().equals(""))
                        System.out.println(sb);
                }
                sequenceStart = i;
                next = Long.parseLong(messages[i][0]) + 1;
            } else {
                long index = Long.parseLong(messages[i][0]);
                if (index != next) {
                    sequenceStart = -1;
                    next = -1;
                } else {
                    next++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] result = new FindValidSequence().validSequences(7,
                new String[][]{{"2", "a"}, {"1", "*"}, {"3", "*"}, {"1232432", "w"}, {"1232434", "*"}, {"1232431", "*"},
                        {"1232433", "a"}});

        System.out.print(result[0]);
        for (int i = 1; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }

        // If found a proper sequence, print the sequence

        // Input
        // [["2","a"],["1","*"],["3","*"],["65765","w"],["65764","*"],["65766","a"],["65767","*"]]

        // Output
        // a
        // wa

        // Input
        // [["2","a],["3","*"],["5","*"],["4","z"]]

        // Output
        // z
    }
}
