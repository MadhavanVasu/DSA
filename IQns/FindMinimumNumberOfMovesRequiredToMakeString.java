package IQns;

public class FindMinimumNumberOfMovesRequiredToMakeString {

    public int findNumberOFMoves(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) charFreq[c - 'a']++;
        int result = 0;
        for (int x : charFreq) result += (x / 2);
        return result;
    }

    public static void main(String[] args) {
        String s = "bcaabca";
        System.out.println(new FindMinimumNumberOfMovesRequiredToMakeString().findNumberOFMoves(s));
    }

}
