package LeetCode.Easy;

public class ValidAnagram {

    // Using array for frequency
    public boolean isAnagram(String s, String t) {
        int[] charFreqArr = new int[26];
        for (char x : s.toCharArray()) charFreqArr[x - 'a']++;
        for (char x : t.toCharArray()) charFreqArr[x - 'a']--;
        for (int x : charFreqArr)
            if (x != 0) return false;
        return true;
    }

    // Using Map
    // public boolean isAnagram(String s, String t) {
    //     Map<Character, Integer> charMap = new HashMap<>();
    //     for(char x : s.toCharArray())
    //         charMap.put(x, charMap.getOrDefault(x, 0) + 1);
    //     for(char x : t.toCharArray())
    //     {
    //         if(!charMap.containsKey(x)) return false;
    //         charMap.put(x, charMap.get(x) - 1);
    //         if(charMap.get(x) < 0) return false;
    //     }
    //     for(char x : charMap.keySet())
    //         if(charMap.get(x) != 0) return false;
    //     return true;
    // }


}
