package LeetCode.Medium;

public class StringCompression {

    public static int compress(char[] chars) {
        int prev = 0;
        int count = 1;
        int len = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i != chars.length && chars[i] == chars[prev]) {
                count++;
            } else {
                chars[len] = chars[prev];
                if (count != 1) {
                    len += 1;
                    int divisor = 1;
                    if (count >= 10 && count <= 99) divisor = 10;
                    else if (count >= 100 && count <= 999) divisor = 100;
                    else if (count >= 1000 && count <= 2001) divisor = 1000;
                    while (divisor > 0) {
                        char c = (char) (count / divisor + 48);
                        chars[len++] = c;
                        count = count % divisor;
                        divisor /= 10;
                    }
                } else len++;
                prev = i;
                count = 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        char[] chars = {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o' };
        System.out.println(compress(chars));


    }

}
