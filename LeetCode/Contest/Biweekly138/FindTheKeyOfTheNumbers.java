package LeetCode.Contest.Biweekly138;

public class FindTheKeyOfTheNumbers {

    public int generateKey(int num1, int num2, int num3) {
        String zeros = "000";
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);
        String n3 = String.valueOf(num3);
        n1 = zeros.substring(4 - n1.length()) + n1;
        n2 = zeros.substring(4 - n2.length()) + n2;
        n3 = zeros.substring(4 - n3.length()) + n3;
        int result = 0;
        int power = 3;
        for (int i = 0; i < 4; i++) {
            int min = Math.min(Math.min(n1.charAt(i) - '0', n2.charAt(i) - '0'), n3.charAt(i) - '0');
            result += Math.pow(10, power) * min;
            power--;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
