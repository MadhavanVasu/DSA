package LeetCode.Medium;

public class AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++)
            if (s.charAt(i) == t.charAt(j)) j++;
        return t.length() - j;
    }

    public static void main(String[] args) {

    }

}
