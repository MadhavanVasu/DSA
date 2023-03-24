package LeetCode.Medium;

public class ProductOfArrayExceptSelf {

    public int binSearch(int target, int[] prefix, int days, int n, int start, int end, int prev, int minJump)
    {
        if(days==0 && start>=n-1)
            return prefix[start] - prev;
        int e = end;
        while(start<=e)
        {
            int mid = (start+e)/2;
            if(target==prefix[mid])
            {
                int curr = prefix[mid]-prev;
                int jumps = binSearch(prefix[mid]+minJump, prefix, days-1, n, mid+1, end, prefix[mid], minJump);
                return Math.max(curr, jumps);
            }
            else if(target<prefix[mid])
                e = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

    public int shipWithinDaysBin(int[] weights, int days) {

        int n = weights.length;
        int[] prefix = new int[n];
        prefix[0] = weights[0];
        for(int i=1; i<n; i++) prefix[i] = weights[i] + prefix[i-1];
        int sum = prefix[n-1];
        int min = sum/days;
        int a = binSearch(min,prefix,days,n,0,n-1,0,min);
        int b = binSearch(min+1,prefix,days,n,0,n-1,0,min+1);
        return Math.max(a,b);
    }

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int product;
        int[] result = new int[n];
        for(int i=0; i<n; i++) result[i] = 1;
        product = nums[0];
        for(int i=1; i<n; i++) {
            result[i] *= product;
            product*=nums[i];
        }
        product = nums[n-1];
        for(int i=n-2; i>=0; i--)
        {
            result[i]*=product;
            product*=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
