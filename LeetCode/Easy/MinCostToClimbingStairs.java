package LeetCode.Easy;

public class MinCostToClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] costArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int oneStep = i + 1 >= n ? 0 : costArr[i + 1];
            int twoStep = i + 2 >= n ? 0 : costArr[i + 2];
            costArr[i] = Math.min(cost[i] + oneStep, cost[i] + twoStep);
        }
        return Math.min(costArr[0], costArr[1]);
    }

    public static void main(String[] args) {

    }

}
