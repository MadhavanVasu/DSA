package LeetCode.Medium;

public class CountNumberOfTeams {

    public int numTeamsOptimized(int[] rating) {
        int n = rating.length;
        int teams = 0;
        for (int i = 1; i < n - 1; i++) {
            int[] lesserElements = new int[2];
            int[] greaterElements = new int[2];
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) lesserElements[0]++;
                else greaterElements[0]++;
            }

            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) lesserElements[1]++;
                else greaterElements[1]++;
            }
            teams += (lesserElements[0] * greaterElements[1]);
            teams += (greaterElements[0] * lesserElements[1]);
        }
        return teams;
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] greaterElementsCount = new int[n];
        int[] lesserElementsCount = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) greaterElementsCount[i]++;
                else lesserElementsCount[i]++;
            }
        }
        int teams = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (rating[j] < rating[i]) {
                    teams += lesserElementsCount[j];
                } else teams += greaterElementsCount[j]++;
            }
        }
        return teams;
    }

    public static void main(String[] args) {

    }

}
