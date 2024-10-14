package LeetCode.Contest.Weekly413;

public class CheckIfTwoChessboardSquaresHaveTheSameColor {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1 = (('a' - coordinate1.charAt(0)) % 2);
        int c2 = (('a' - coordinate2.charAt(0)) % 2);
        if (coordinate1.charAt(1) % 2 != c1) {
            c1 = (c1 + 1) % 2;
        }
        if (coordinate2.charAt(1) % 2 != c2) {
            c2 = (c2 + 1) % 2;
        }
        return c1 == c2;

    }

    public static void main(String[] args) {

    }


}
