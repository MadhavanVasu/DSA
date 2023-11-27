package LeetCode.Medium;

public class RemoveColoredPieces {

    public boolean winnerOfGame(String colors) {
        int aliceCount = 0;
        int bobCount = 0;
        int lastChar = 0;
        for (int i = 1; i <= colors.length(); i++) {
            if (i == colors.length() || colors.charAt(i) != colors.charAt(lastChar)) {
                int count = i - lastChar;
                if (count > 2) {
                    if (colors.charAt(lastChar) == 'A') aliceCount += (count - 2);
                    else bobCount += (count - 2);
                }
                lastChar = i;
            }
        }
        return aliceCount > bobCount;
    }

    public static void main(String[] args) {

    }

}
