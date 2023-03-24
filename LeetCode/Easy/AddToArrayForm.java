package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        int carry = 0;
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int i = n-1;
        int sum = 0;
        while(carry!=0 || i>=0 || k!=0)
        {
            sum = carry;
            if(i>=0)
                sum+=num[i];
            if(k>0)
                sum+=(k%10);
            result.add(0,sum%10);
            carry = sum/10;
            i--;
            k = k/10;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] num = {2,1,5};
        int k = 806;
        System.out.println(addToArrayForm(num, k));
    }

}
