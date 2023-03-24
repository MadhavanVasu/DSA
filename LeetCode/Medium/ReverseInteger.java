package LeetCode.Medium;

public class ReverseInteger {

    public int reverse(int x) {
        int f = 0;
        if(x<0) {
            f = 1;
            x = -x;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        long revInt = Long.parseLong(sb.toString());
        if(f==1)
            revInt = -revInt;
        if(revInt<-Math.pow(2,31) ||  revInt>Math.pow(2,31)-1)
            return 0;
        return (int)revInt;

    }

    public static void main(String[] args) {

    }

}
