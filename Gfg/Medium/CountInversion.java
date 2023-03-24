package Gfg.Medium;

public class CountInversion {

    public static long merge(int start, int end, long arr[])
    {
        int mid = (start+end)/2;
        int i = start;
        int j = mid+1;
        long temp[] = new long[end-start+1];
        int k = 0;
        long count = 0;
        while(i<=mid && j<=end)
        {
            if(arr[i]>arr[j])
            {
                count+=(mid-i+1);
                temp[k] = arr[j];
                j++;
            }
            else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        if(i>mid)
        {
            while(j<=end)
            {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        else
        {
            while (i<=mid)
            {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }
        i = 0;
        while (start<=end)
        {
            arr[start] = temp[i];
            i++;
            start++;
        }
        return count;
    }

    public static long mergeSort(int start, int end, long arr[], long res)
    {
        if(start<end)
        {
            int mid = (start+end)/2;
            long temp1 = mergeSort(start,mid, arr,res);
            long temp2 =mergeSort(mid+1,end, arr,res);
            res = temp1+temp2;
        }

        res+= merge(start,end,arr);
        return res;


    }

    public static long inversionCount(long arr[], long N)
    {

        return mergeSort(0,arr.length-1,arr,0);

    }

    public static void main(String[] args) {
        int N = 5;
        long arr[] = {5,4,3,2,1};

        System.out.println(inversionCount(arr, N));
    }

}
