package LeetCode.Contest.Weekly394;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfSpecialCharacter2 {

    public int numberOfSpecialChars(String word) {
        int[] lowerChar = new int[26];
        Set<Character> set = new HashSet<>();
        for (Character c : word.toCharArray()) {
            if (c >= 97 && c <= 122) lowerChar[c - 'a']++;
        }
        int result = 0;
        for (Character c : word.toCharArray()) {
            if (c >= 97 && c <= 122) lowerChar[c - 'a']--;
            else {
                int diff = c - 'A';
                if (lowerChar[diff] == 0 && !set.contains(c)) {
                    result++;
                    set.add(c);
                } else set.add(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
