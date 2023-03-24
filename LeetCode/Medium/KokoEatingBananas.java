package LeetCode.Medium;

public class KokoEatingBananas {

    public static boolean feasible(int bananasPerHour, int[] piles, int h)
    {
        int hrs = 0;
        for(int pile : piles)
        {
            hrs += pile/bananasPerHour;
            if(pile%bananasPerHour!=0)
                hrs+=1;
            if(hrs>h)
                return false;
        }
        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int max = Integer.MIN_VALUE;
        for(int x : piles) if(x>max) max=x;
        int right = max;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(feasible(mid, piles, h))
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

}
