package LeetCode.Easy;

public class PassThePillow {

    public int passThePillow2(int n, int time) {
        int rem = time%(n-1);
        int q = time/(n-1);
        return q%2==0? 1+rem : n-rem;

    }

    public int passThePillow(int n, int time) {
        int f = 0;
        while (time>=n)
        {
            time-=(n-1);
            if(f==0)
                f = 1;
            else
                f = 0;
        }
        return f==0? 1+time : n-time;

    }

    public static void main(String[] args) {

    }

}
