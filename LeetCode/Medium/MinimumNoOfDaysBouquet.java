package LeetCode.Medium;

public class MinimumNoOfDaysBouquet {

    public static boolean feasible(int days, int[] bloomDay, int m, int k, int n)
    {
        int flowers = 0;
        int bouquetCount = 0;
        for(int i=0; i<n; i++)
        {
            if(bloomDay[i]<=days)
            {
                flowers+=1;
                if(flowers%k==0)
                    bouquetCount+=1;
                if(bouquetCount>=m)
                    return true;
            }
            else
                flowers = 0;
        }
        return bouquetCount == m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long flowerCount = (long)m*k;
        System.out.println(flowerCount);
        if(flowerCount>n)
            return -1;
        int left  = -1;
        int right = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            if(bloomDay[i]<left || left==-1)
                left = bloomDay[i];
            if(bloomDay[i]>right)
                right = bloomDay[i];
        }
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(feasible(mid,bloomDay,m,k,n))
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {

        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 89945;
        int k = 32127;
        System.out.println(minDays(bloomDay,m,k));



    }

}
