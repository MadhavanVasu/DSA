package LeetCode.Easy;

public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return numOnes >= k ? k : (numZeros >= k - numOnes ? numOnes : numOnes - (k - numOnes - numZeros));
    }

    public static void main(String[] args) {

    }

}
