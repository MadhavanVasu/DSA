package LeetCode.Medium;

import java.util.*;

public class SortVowelsInAString {


    public String sortVowels(String s) {
        List<Character> vowelsPresent = new ArrayList<>();
        Set<Character> vowelsSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (Character c : s.toCharArray()) {
            if (vowelsSet.contains(c)) vowelsPresent.add(c);
        }
        Collections.sort(vowelsPresent);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (vowelsSet.contains(c)) sb.append(vowelsPresent.get(i++));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
