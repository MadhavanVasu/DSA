package LeetCode.Medium;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid - 1 < 0 || arr[mid - 1] < arr[mid]) && (mid + 1 >= n || arr[mid + 1] < arr[mid]))
                return mid;
            else if ((mid - 1 >= 0 && arr[mid] > arr[mid - 1]) || (mid + 1 < n && arr[mid] < arr[mid + 1]))
                start = mid + 1;
            else end = mid - 1;
        }
        return -1;

    }

    public static void main(String[] args) {

    }

}
