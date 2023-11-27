package LeetCode.Medium;

public class FindTheOriginalArrayOfPrefixXOR {

    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        int currXOR = 0;
        int i = 0;
        for (int x : pref) {
            result[i] = currXOR ^ x;
            currXOR ^= result[i];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
