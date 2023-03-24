package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> map = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)
            return false;
        for(int i=0; i<n1; i++)
        {
            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i),1);
        }
        for(int i=0;i<n2-n1+1; i++)
        {
            Map<Character, Integer> temp = new HashMap<>(map);
            int f = 0;
            for(int j=0; j<n1; j++)
            {
                if(temp.containsKey(s2.charAt(i+j)) && temp.get(s2.charAt(i+j))!=0)
                {
                    temp.put(s2.charAt(i+j), temp.get(s2.charAt(i+j))-1);
                }
                else
                {
                    f = 1;
                    break;
                }
            }
            if(f!=1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
