package LeetCode.Easy;

public class Maximum69Number {

    public int maximum69Number2(int num) {

        int sixPos = -1;
        int tempNum = num;
        int pos = 0;
        while (tempNum > 0) {
            int rem = tempNum % 10;
            if (rem == 6)
                sixPos = pos;
            pos++;
            tempNum = tempNum/10;
        }
        return sixPos==-1? num : num+ 3*(int)Math.pow(10,sixPos);
    }

    public int maximum69Number(int num) {

        int res = 0;
        int divisor = (int) Math.pow(10, (int) Math.floor(Math.log(num)));
        int f = 0;
        while (divisor > 0) {
            int rem = num / divisor;
            if (rem == 6 && f != 1) {
                res += (9 * divisor);
                f = 1;
            } else
                res += (rem * divisor);
            num = num % divisor;
            divisor = divisor / 10;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
