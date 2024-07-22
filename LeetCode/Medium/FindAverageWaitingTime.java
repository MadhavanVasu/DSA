package LeetCode.Medium;

public class FindAverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        double result = 0;
        int currEnd = 0;
        int n = customers.length;
        for (int[] customer : customers) {
            if (currEnd <= customer[0]) {
                result += (customer[1]);
                currEnd = customer[0] + customer[1];
            } else {
                int diff = currEnd - customer[0];
                result += (diff + customer[1]);
                currEnd += customer[1];
            }
        }
        return (result / n);
    }

    public static void main(String[] args) {

    }
}
