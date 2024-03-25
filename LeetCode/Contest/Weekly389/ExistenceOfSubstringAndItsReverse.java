package LeetCode.Contest.Weekly389;

public class ExistenceOfSubstringAndItsReverse {

    public boolean isSubstringPresent(String s) {
        char a = 'a';
        char b = 'a';
        for (int i = 0; i < s.length() - 1; i++) {
            a = s.charAt(i);
            b = s.charAt(i + 1);
            for (int j = 0; j < s.length() - 1; j++) {
                if (j != i) {
                    if (s.charAt(j) == b && s.charAt(j + 1) == a) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
