package LeetCode.Medium;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] charCountS = new int[26];
        int[] charCountT = new int[26];
        for (char c : s.toCharArray())
            charCountS[(int) c - 'a']++;
        for (char c : t.toCharArray())
            charCountT[(int) c - 'a']++;
        int result = 0;
        for (int i = 0; i < 26; i++)
            if (charCountS[i] > charCountT[i]) result += (charCountT[i] - charCountS[i]);
        return result;
    }

    public static void main(String[] args) {

    }

}
