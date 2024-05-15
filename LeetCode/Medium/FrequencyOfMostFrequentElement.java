package LeetCode.Medium;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {

    public int maxFrequencySlidingWindow(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        long prefixSum = nums[0];
        int result = 1;
        for (int i = 1; i < n; i++) {
            prefixSum += nums[i];
            while ((long) (i - left + 1) * nums[i] - prefixSum > k) {
                long sum = ((long) nums[i] * (i + 1));
                long diff = sum - prefixSum;
                if (diff <= k) break;
                prefixSum -= nums[left];
                left++;
            }
            int elements = (i - left + 1);
            if (elements > result) result = elements;
        }
        return result;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n];
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += ((long) (nums[i] - nums[i - 1]) * i);
            prefixSum[i] = sum;
        }
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (prefixSum[i] > k) {
                int start = 0;
                int end = i - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (mid == 0) sum = prefixSum[i];
                    else sum = (long) (nums[i] - nums[mid]) * mid + prefixSum[mid];
                    if (sum <= k) {
                        int elements = i - mid + 1;
                        if (ans < elements) ans = elements;
                        end = mid - 1;
                    } else start = mid + 1;
                }
            } else ans = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
