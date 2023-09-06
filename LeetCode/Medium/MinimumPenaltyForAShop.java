package LeetCode.Medium;

public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        int currPenalty = 0;
        int yesCount = 0;
        int noCount = 0;

        for (Character c : customers.toCharArray()) {
            if (c == 'Y') yesCount++;
            else noCount++;
        }

        int min = noCount;
        int answer = customers.length();



        for (int i = customers.length() - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'N') noCount--;
            else {
                yesCount--;
                currPenalty++;
            }
            int res = noCount + currPenalty;
            if (res <= min) {
                min = res;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(new MinimumPenaltyForAShop().bestClosingTime("YYNY"));

    }

}
