package LeetCode.Contest.Weekly347;

public class RemoveTrailingZeroes {

    public String removeTrailingZeros(String num) {
        int n = num.length();
        int index = n;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') break;
            index = i;
        }
        return num.substring(0, index);
    }

    public static void main(String[] args) {

        String num = "51230100";
        System.out.println(new RemoveTrailingZeroes().removeTrailingZeros(num));

    }

}
