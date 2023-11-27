package LeetCode.Contest.Biweekly118;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int c : words[i].toCharArray()) {
                if (c == x) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
