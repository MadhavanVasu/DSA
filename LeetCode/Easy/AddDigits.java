package LeetCode.Easy;

public class AddDigits {
    public int addDigitsOptimal(int num) {
        if (num == 0)
            return 0;
        else if (num % 9 == 0)
            return 9;
        else
            return num % 9;
    }

    public int addDigits(int num) {
        while (num / 10 != 0) {
            int rem = num % 10;
            num = num / 10;
            num += rem;
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
