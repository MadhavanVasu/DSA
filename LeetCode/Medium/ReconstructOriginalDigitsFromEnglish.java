package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {

    public int reduceFreq(String word, Map<Character, Integer> charFreq, char ch) {
        int count = 0;
        while (charFreq.get(ch) != 0) {
            for (char c : word.toCharArray())
                charFreq.put(c, charFreq.get(c) - 1);
            count++;
        }
        return count;
    }

    public String originalDigits(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < 26; i++) charFreq.put((char) ('a' + i), 0);
        for (char c : s.toCharArray()) charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        boolean flag = true;
        int[] digitCount = new int[10];
        while (flag) {
            if (charFreq.get('z') != 0) {
                digitCount[0] += reduceFreq("zero", charFreq, 'z');
            } else if (charFreq.get('w') != 0) {
                digitCount[2] += reduceFreq("two", charFreq, 'w');
            } else if (charFreq.get('u') != 0) {
                digitCount[4] += reduceFreq("four", charFreq, 'u');
            } else if (charFreq.get('x') != 0) {
                digitCount[6] += reduceFreq("six", charFreq, 'x');
            } else if (charFreq.get('g') != 0) {
                digitCount[8] += reduceFreq("eight", charFreq, 'g');
            } else if (charFreq.get('h') != 0) {
                digitCount[3] += reduceFreq("three", charFreq, 'h');
            } else if (charFreq.get('f') != 0) {
                digitCount[5] += reduceFreq("five", charFreq, 'f');
            } else if (charFreq.get('v') != 0) {
                digitCount[7] += reduceFreq("seven", charFreq, 'v');
            } else if (charFreq.get('o') != 0) {
                digitCount[1] += reduceFreq("one", charFreq, 'o');
            } else if (charFreq.get('n') != 0) {
                digitCount[9] += reduceFreq("nine", charFreq, 'n');
            } else flag = false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (digitCount[i] != 0) {
                sb.append(i);
                digitCount[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

// two, seven
// one
// tw sev
// six six one one one five

// z -> zero
// w -> two
// u -> four
// x -> six
// g -> eight
// h -> three
// f -> five
// v -> seven
// o -> one
// n -> nine


    }

}
