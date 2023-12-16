package LeetCode.Contest.Weekly375;

public class CountTestedDevicesAfterTestOperations {

    public int countTestedDevices(int[] batteryPercentages) {
        int chargeReduced = 0;
        int deviceTested = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - chargeReduced > 0) {
                deviceTested++;
                chargeReduced++;
            }
        }
        return deviceTested;
    }

    public static void main(String[] args) {

    }

}
