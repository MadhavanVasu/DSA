package LeetCode.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    // O(N log N) solution
    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        int n = strs.length;
        String start = strs[0];
        String end = strs[n-1];
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<start.length(); i++)
        {
            if(start.charAt(i)!=end.charAt(i))
                break;
            sb.append(start.charAt(i));
        }
        return sb.toString();
    }

    // O(M*N) Solution
    public static String longestCommonPrefix2(String[] strs) {

        int n = strs.length;
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<strs[0].length(); i++)
        {
            for(int j=1; j<n; j++)
            {
                if(i>=strs[j].length())
                    return sb.toString();
                if(strs[j].charAt(i)!=strs[0].charAt(i))
                    return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

}
