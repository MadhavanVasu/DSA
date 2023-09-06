package LeetCode.Contest.Contest361;

public class MinimumOperationsToMakeSpecial {

    public int minimumOperations(String num) {

        int n = num.length();
        int removed = n;
        int i = n - 1;
        boolean contains0or1 = false;
        while (i >= 0) {
            if (num.charAt(i) == '1' && num.charAt(i) == '0') contains0or1 = true;
            if (num.charAt(i) == '0' || num.charAt(i) == '5') {
                int j = i - 1;
                boolean found = false;
                while (j >= 0) {
                    if (num.charAt(i) == '0' && (num.charAt(j) == '5' || num.charAt(j) == '0')) {
                        found = true;
                        break;
                    } else if (num.charAt(i) == '5' && (num.charAt(j) == '2' || num.charAt(j) == '7')) {
                        found = true;
                        break;
                    }
                    j--;
                }
                if (found) {
                    int charRemoved = (n - (i + 1)) + (i - (j + 1));
                    if (charRemoved < removed) removed = charRemoved;
                }
            }
            i--;
        }
        if (removed == n && contains0or1) return n - 1;
        return removed;
    }

    public static void main(String[] args) {

        System.out.println(new MinimumOperationsToMakeSpecial().minimumOperations("2245047"));

    }

}
