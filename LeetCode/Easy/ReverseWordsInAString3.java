package LeetCode.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseWordsInAString3 {


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                for (int j = i - 1; j >= 0; j--) {
                    if (s.charAt(j) != ' ') sb.append(s.charAt(j));
                    else break;
                }
                if (i != s.length()) sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
