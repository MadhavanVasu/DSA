package LeetCode.Easy;

public class ElementAppearingMoreThan25Percent {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        // 25% percent of the time -> 1/4 times
        int reqdCount = n / 4;
        int count = 0;
        int prev = arr[0];
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == prev) count++;
            else{
                if(count > reqdCount) return prev;
                count = 1;
                prev = arr[i];
            }
        }
        return prev;
    }

    public static void main(String[] args) {

    }

}
