package LeetCode.Contest.Weekly350;

public class TotalDistanceTravelled {

    public int distanceTraveled(int mainTank, int additionalTank) {

        int answer = 0;
        while (mainTank >= 5) {
            answer += (5 * 10);
            mainTank -= 5;
            if (additionalTank > 0) {
                mainTank += 1;
                additionalTank -= 1;
            }
        }
        answer += (mainTank * 10);
        return answer;

    }

    public static void main(String[] args) {

    }

}
