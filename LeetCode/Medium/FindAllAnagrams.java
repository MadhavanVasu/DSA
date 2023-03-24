package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagrams {

    public static boolean matches(int[] arr1, int[] arr2)
    {
        for(int i=0; i<26; i++)
        {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        List<Integer> result = new ArrayList<>();
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i=0; i<n2; i++)
        {
            map1[s.charAt(i)-'a']+=1;
            map2[p.charAt(i)-'a']+=1;
        }
        int i;
        for(i=0; i<n1-n2; i++)
        {
            if(matches(map1, map2))
                result.add(i);
            map1[s.charAt(i)-'a']--;
            map1[s.charAt(i+n2)-'a']++;
        }
        if(matches(map1, map2))
            result.add(i);
        return result;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s,p));
    }

}
