package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    Map<Character, List<Character>> digitAlpha;

    public LetterCombinationsOfAPhoneNumber() {
        digitAlpha = new HashMap<>();
        char start = 'a';
        for (int i = 2; i <= 9; i++) {
            char digit = (char) (i + '0');
            digitAlpha.put(digit, new ArrayList<>());
            for (int j = 0; j < 3; j++)
                digitAlpha.get(digit).add(start++);
            if (i == 7 || i == 9)
                digitAlpha.get(digit).add(start++);
        }
    }

    public List<String> helper(int i, String digits) {
        if (i == digits.length())
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (Character x : digitAlpha.get(digits.charAt(i))) {
            List<String> permutations = helper(i + 1, digits);
            if (!permutations.isEmpty()) {
                for (String permutation : permutations)
                    result.add(x + permutation);
            } else
                result.add(String.valueOf(x));
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        return helper(0, digits);
    }

    public List<String> letterCombinationsIterative(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            if (i == digits.length() - 1) {
                for (Character x : digitAlpha.get(digits.charAt(i)))
                    result.add(String.valueOf(x));
            } else {
                List<String> temp = new ArrayList<>();
                for (Character x : digitAlpha.get(digits.charAt(i))) {
                    for (String y : result)
                        temp.add(x + y);
                }
                result = new ArrayList<>(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));

    }

}
