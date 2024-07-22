package LeetCode.Contest.Weekly399;

public class StringCompression3 {

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 1;
        int count = 1;
        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                if (count + 1 > 9) {
                    comp.append('9' + word.charAt(i));
                    count = 1;
                } else count++;
            } else {
                char c = (char) (count + '0');
                comp.append(c);
                comp.append(word.charAt(i - 1));
                count = 1;
            }
            i++;
        }
        char c = (char) (count + '0');
        comp.append(c);
        comp.append(word.charAt(i - 1));
        return comp.toString();
    }

    public static void main(String[] args) {

    }

}
