package LeetCode.Easy;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] temp1 = new int[n/2];
        int[] temp2 = new int[n/2];
        for(int i=n/2; i<n; i++)
            temp1[i-n/2] = nums[i];
        for(int i=0; i<n/2; i++)
            temp2[i] = nums[i];
        int pos = 0;
        for(int i = 0; i<n; i+=2)
            nums[i] = temp2[pos++];
        pos = 0;
        for(int i=1; i<n; i+=2)
            nums[i] = temp1[pos++];
        return nums;
    }

    public static void main(String[] args) {

    }

}
