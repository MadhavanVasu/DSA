package LeetCode.Contest.Weekly382;

public class NumberOfChangingKeys {

    public int countKeyChanges(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            int prevASCII = s.charAt(i - 1);
            int currASCII = s.charAt(i);
            if (prevASCII != currASCII) {
                if (prevASCII >= 65 && prevASCII <= 90) {
                    int diff = prevASCII - 65;
                    if (97 + diff != currASCII) result++;
                } else if (prevASCII >= 97 && prevASCII <= 122) {
                    int diff = prevASCII - 97;
                    if (65 + diff != currASCII) result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
