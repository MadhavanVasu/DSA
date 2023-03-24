package Easy;
import java.util.HashMap;
import java.util.Map;

public class ContDupTwo{

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(k==0)
            return false;
        if(k>=n)
            k=n-1;
        Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
        int i;
        int s = 0;
        for(i=0;i<=k;i++)
        {
            if(dict.containsKey(nums[i])){
                return true;
            }
                
            else
            {
                dict.put(nums[i], i);
            }
                
        }
        dict.put(nums[0], -1);
        s+=1;
        i = k+1;
        while(i<n)
        {
            if(dict.containsKey(nums[i]) && dict.get(nums[i])!=-1)
            {
                return true;
            }  
            else{
                dict.put(nums[i], i);
            }
            dict.put(nums[s], -1);
            s+=1;
            i+=1;
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}