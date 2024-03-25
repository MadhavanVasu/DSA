package LeetCode.Contest.Weekly389;

public class CountSubstringStartingAndEndingWithTheSameCharacter {

    public long countSubstrings(String s, char c) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return (count * (count + 1)) / 2;
    }

    public static void main(String[] args) {

    }

}
