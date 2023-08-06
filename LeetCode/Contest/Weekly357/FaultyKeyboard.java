package LeetCode.Contest.Weekly357;

public class FaultyKeyboard {

    public String finalString(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i')
                sb.append(s.charAt(i));
            else
                sb.reverse();
        }
        return sb.toString();

    }

    public static void main(String[] args) {

    }

}
