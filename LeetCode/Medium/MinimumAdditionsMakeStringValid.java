package LeetCode.Medium;

public class MinimumAdditionsMakeStringValid {

    public static int addMinimum(String word) {
        int res = 0;
        char expected = 'a';
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == expected) i++;
            else res += 1;
            expected = (char) ('a' + ((expected - 'a') + 1) % 3);
        }
        res += ('c' - word.charAt(i - 1));
        return res;
    }

    public static void main(String[] args) {

        String word = "aba";
        System.out.println(addMinimum(word));

    }

}
