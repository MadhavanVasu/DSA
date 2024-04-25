package LeetCode.Contest.Weekly391;

public class WaterBottles2 {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = 0;
        int empty = 0;
        while (numBottles + empty >= numExchange) {
            result += numBottles;
            empty += numBottles;
            numBottles = 0;
            if (empty >= numExchange) {
                numBottles++;
                empty -= numExchange;
                numExchange++;
            }
        }
        return result + numBottles;
    }

    public static void main(String[] args) {

    }

}
