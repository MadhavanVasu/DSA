package LeetCode.Contest.Weekly356;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShortestStringContainsThreeSub {

    public String subStringOverLapConcat(String s1, String s2) {
        String result = s1;
        for (int i = 0; i < s1.length(); i++) {
            int temp = i;
            int j = 0;
            for (j = 0; j < s2.length(); j++) {
                if (temp == s1.length() || s1.charAt(temp) != s2.charAt(j)) break;
                temp++;
            }
            if (temp == s1.length()) {
                result += (s2.substring(j));
                return result;
            }
        }
        return s1 + s2;
    }

    public String minimumString(String a, String b, String c) {
        List<String> strings = new ArrayList<>();
        String[] arr = new String[]{a, b, c};
        for (int i = 0; i < 3; i++) {
            String x = arr[i];
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    x = subStringOverLapConcat(arr[i], arr[j]);
                    for (int k = 0; k < 3; k++) {
                        if (k != i && k != j) {
                            x = subStringOverLapConcat(x, arr[k]);
                            strings.add(x);
                        }

                    }
                }
            }
        }
        Comparator<String> myComp = (o1, o2) -> {
            if (o1.length() < o2.length())
                return -1;
            else if (o1.length() > o2.length()) return 1;
            else
                return o1.compareTo(o2);
        };
        strings.sort(myComp);
        return strings.get(0);
    }

    public static void main(String[] args) {

        String a = "ca";
        String b = "a";
        String c = "a";
        System.out.println(new ShortestStringContainsThreeSub().minimumString(a, b, c));

        /*
        0

         */
        for(int j=0; j<5; j++) {

            System.out.println(j);
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    break;
                }
            }

        }
        // Outside body of the loop
        System.out.println("out");

    }

}
