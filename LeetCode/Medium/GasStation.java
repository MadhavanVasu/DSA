package LeetCode.Medium;

import java.util.Arrays;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;

        int total = 0;
        int pos = 0;
        for (int i = 0; i < gas.length; i++)
        {
            total+=(gas[i]-cost[i]);

            if(total<0)
            {
                total = 0;
                pos = i+1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        System.out.println(canCompleteCircuit(gas, cost));

    }
}
