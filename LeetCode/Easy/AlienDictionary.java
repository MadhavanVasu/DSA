package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> alphaOrder = new HashMap<>();
        for (int i = 0; i < 26; i++)
            alphaOrder.put(order.charAt(i), i);
        for(int i=0; i< words.length-1; i++)
        {
            String str1 = words[i];
            String str2 = words[i+1];
            int j=0;
            int k=0;
            int f = 0;
            while(j<str1.length() && k<str2.length())
            {
                System.out.println(str1.charAt(j) + " " + str2.charAt(k));
                if(alphaOrder.get(str1.charAt(j))==alphaOrder.get(str2.charAt(k)))
                {
                    j++;
                    k++;
                } else if (alphaOrder.get(str1.charAt(j))<alphaOrder.get(str2.charAt(k))) {
                    f = 1;
                    break;
                }
                else return false;
            }
            if(f==0 && str1.length()>str2.length())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"ubg","kwh"};
        String order = "qcipyamwvdjtesbghlorufnkzx";
        System.out.println(isAlienSorted(words,order));

    }

}
