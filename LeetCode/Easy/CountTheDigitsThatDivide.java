package LeetCode.Easy;

public class CountTheDigitsThatDivide {

    public int countDigits(int num) {
        int tempNum = num;
        int count = 0;
        while (tempNum > 0) {
            int rem = tempNum % 10;
            if (num % rem == 0) count++;
            tempNum = tempNum / 10;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
