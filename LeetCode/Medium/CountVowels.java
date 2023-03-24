package LeetCode.Medium;

import java.util.Arrays;

public class CountVowels {

    public static int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] prefixSum = new int[n];
        int count = 0;
        int i = 0;
        for (String x : words) {
            char c1 = x.charAt(0);
            char c2 = x.charAt(x.length() - 1);
            if ((c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') && (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u'))
                count++;
            prefixSum[i++] = count;
        }
        int m = queries.length;
        int[] result = new int[m];
        i = 0;
        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            result[i] = prefixSum[y];
            if (x != 0)
                result[i] -= prefixSum[x - 1];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        String[] words = {"a","e","i"};
        int[][] queries = {{0,2},{0,1},{2,2}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));

    }

}
