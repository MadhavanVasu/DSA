package CodingNinjas.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatNMissing {

    public static int[] missNRep2(ArrayList<Integer> arr, int n)
    {
        long sqSum = 0;
        int[] res = new int[2];
        long sum = 0;
        long arrSum = arr.stream().mapToInt(Integer::intValue).sum();
        long actualSum = 0;
        long actualSqSum = 0;
        for(int i=0; i<n; i++)
        {
            sqSum+=(arr.get(i)*arr.get(i));
            actualSum+=(i+1);
            actualSqSum+=((i+1)*(i+1));
        }
        long diff1 = actualSum - arrSum;
        long sqDiff = actualSqSum - sqSum;
        long missNRep = sqDiff/diff1;
        res[0] = (int)((missNRep + diff1)/2);
        res[1] = (int)(res[0] - diff1);
        return res;
    }

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] res = new int[2];
        int i = 0;
        while (i<n)
        {
            while (true)
            {
                if(arr.get(i) - 1 != i)
                {
                    if(arr.get(arr.get(i)-1)==arr.get(i))
                    {
                        res[0] = i+1;
                        res[1] = arr.get(i);
                        i++;
                        break;
                    }
                    int temp = arr.get(i);
                    arr.set(i,arr.get(arr.get(i)-1));
                    arr.set(temp-1,temp);
                }
                else {
                    i++;
                    break;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int n = 5;
        ArrayList<Integer> arr = new ArrayList<>(List.of(5,4,2,4,1));
        System.out.println(Arrays.toString(missNRep2(arr,n)));

    }

}
