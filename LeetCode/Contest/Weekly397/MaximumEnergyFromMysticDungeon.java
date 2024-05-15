package LeetCode.Contest.Weekly397;

public class MaximumEnergyFromMysticDungeon {

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MIN_VALUE;
            max = Math.max(max, energy[i]);
        }
        for (int i = 0; i <= n - k; i++) {
            result[i + k] = Math.max(energy[i + k], energy[i] + energy[i + k]);
        }
        for (int i = n - k; i < n; i++) max = Math.max(Math.max(result[i], max), energy[i]);
        return max;
    }

    public static void main(String[] args) {

    }


}
