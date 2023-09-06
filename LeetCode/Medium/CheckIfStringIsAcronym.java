package LeetCode.Medium;

import java.util.List;

public class CheckIfStringIsAcronym {

    public boolean isAcronym(List<String> words, String s) {

        int n = s.length();
        int m = words.size();
        if(n!=m) return false;
        int i = 0;
        for(String word : words)
        {
            if(word.charAt(0)!=s.charAt(i++)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
