package LeetCode.Contest.Weekly333;

public class MinimumOpsToReduceToZero {

    public static int helper(int logNum)
    {
        if(logNum==0)
            return 0;
        int higherLog = (int)Math.ceil(Math.log(logNum) / Math.log(2));
        int lowerLog = (int)Math.floor(Math.log(logNum) / Math.log(2));
        if(higherLog==lowerLog)
            return 1;
        int num1 = (int)Math.pow(2,higherLog) - logNum;
        int num2 = logNum - (int)Math.pow(2,lowerLog);
        int res1 = 1 + helper(num1);
        int res2 = 1 + helper(num2);
        return Math.min(res1,res2);
    }

    public static int minOperations(int n) {
        return helper(n);
    }

    public static void main(String[] args) {
        System.out.println(minOperations(54));
    }

}
