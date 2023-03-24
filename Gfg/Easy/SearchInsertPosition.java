package Gfg.Easy;

public class SearchInsertPosition {

    static int searchInsertK(int Arr[], int N, int k)
    {
        int start = 0;
        int end = N-1;

        while (start<=end)
        {
            int mid = (start+end)/2;
            if(Arr[mid]==k)
                return mid;
            else if(Arr[mid]>k)
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

    public static void main(String[] args) {

        int[] Arr = {1,3,4,6,7};
        System.out.println(searchInsertK(Arr, 5, 6));

    }

}
