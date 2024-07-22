package LeetCode.Medium;

public class NumberOfStepsToReduceABinaryNumberToOne {

    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() != 1) {
            String curr = sb.toString();
            int n = curr.length();
            StringBuilder temp = new StringBuilder();
            if (curr.charAt(n - 1) == '1') {
                int i = n - 1;
                while (i >= 0 && curr.charAt(i--) != '0')
                    temp.append('0');
                temp.append('1');
                i--;
                while (i >= 0)
                    temp.append(curr.charAt(i--));
                sb = temp.reverse();
            } else {
                for (int i = 0; i < n - 1; i++) temp.append(curr.charAt(i));
                sb = temp;
            }
            steps++;
        }
        return steps;
//        int num = 0;
//        int n = s.length();
//        int power = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            num += (s.charAt(i) - '0') * (Math.pow(2, power));
//            power++;
//        }
//        int steps = 0;
//        while (num != 1) {
//            if (num % 2 == 1) num += 1;
//            else num /= 2;
//            steps++;
//        }
//        return steps;
    }

    public static void main(String[] args) {

    }


}
