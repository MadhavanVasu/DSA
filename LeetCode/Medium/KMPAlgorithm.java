package LeetCode.Medium;


public class KMPAlgorithm {

    public static int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();
        int[] piTable = new int[m];
        int i = 0;
        int j = 1;
        while (j < m) {
            if (needle.charAt(i) == needle.charAt(j)) {
                piTable[j] = i + 1;
                i++;
                j++;
            } else if (i != 0)
                i = piTable[i - 1];
            else {
                piTable[j] = 0;
                j++;
            }
        }
        j = 0;
        i = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j != 0)
                j = piTable[j - 1];
            else
                i++;
            if (j == m)
                return i - m;
        }
        return j == m ? i - m : -1;
    }

    public static void main(String[] args) {

        String haystack = "ababcabcabababd";
        String needle = "ababd";
        System.out.println(strStr(haystack, needle));

    }

}
