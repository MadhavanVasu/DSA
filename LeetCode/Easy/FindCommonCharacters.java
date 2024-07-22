package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] commonCharCount = new int[26];
        for (int i = 0; i < words.length; i++) {
            int[] currFreq = new int[26];
            for (int j = 0; j < words[i].length(); j++) currFreq[words[i].charAt(j) - 'a']++;
            for (int j = 0; j < 26; j++) {
                if (commonCharCount[j] != currFreq[j] && i != 0) {
                    commonCharCount[j] = Math.min(commonCharCount[j], currFreq[j]);
                } else commonCharCount[j] = currFreq[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            while (commonCharCount[i] > 0) {
                char c = (char) (i + 'a');
                result.add(String.valueOf(c));
                commonCharCount[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
