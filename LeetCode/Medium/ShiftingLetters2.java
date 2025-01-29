package LeetCode.Medium;

public class ShiftingLetters2 {

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAtEachIndex = new int[n];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            shiftAtEachIndex[start] += direction == 1 ? 1 : -1;
            if (end != n - 1)
                shiftAtEachIndex[end + 1] += direction == 1 ? -1 : 1;
        }
        int currShift = 0;
        for (int i = 0; i < n; i++) {
            currShift += shiftAtEachIndex[i];
            shiftAtEachIndex[i] = currShift;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int newChar = s.charAt(i) + (shiftAtEachIndex[i] % 26);
            if (newChar < (int) 'a') {
                newChar = 'z' - ('a' - newChar - 1);
            } else if (newChar > 'z') {
                newChar = 'a' + (newChar - 'z' - 1);
            }
            sb.append((char) newChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

//    [0, 7, 1]
//    [0, 5, 0]


}
