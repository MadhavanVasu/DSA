package LeetCode.Easy;

public class KthMissingPositiveNumber {

    public static int findKthPositiveBinSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while (left<=right)
        {
            int mid = left + (right-left)/2;
            if(arr[mid] - mid-1 >=k) {
                right = mid - 1;
            }
            else
                left = mid+1;
        }
        return right==-1? 1 : arr[right]+k;
    }

    public static int findKthPositive(int[] arr, int k) {
        int num = 1;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != num)
                k--;
            else
                i++;
            if (k == 0)
                return num;
            num++;
        }
        return num + k;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositiveBinSearch(arr, k));

    }

}
