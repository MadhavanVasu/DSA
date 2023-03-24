package Gfg.Basic;

import java.lang.reflect.Array;
import java.util.*;

public class SubsetSums {

    public static void generateSum(int i, ArrayList<Integer> arr, int sum, ArrayList<Integer> subSum)
    {
        if(i>=arr.size()) {
            return;
        }
        int temp = arr.get(i)+sum;
        subSum.add(temp);
        generateSum(i+1, arr, temp, subSum);
        generateSum(i+1, arr, sum, subSum);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> subSum = new ArrayList<>();
        generateSum(0, arr, 0, subSum);
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(subSum);
        result.add(0);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>() {
            {
                add(5);
                add(2);
                add(1);
            }
        };
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr = (ArrayList<Integer>) Arrays.asList(5,2,1);
        ArrayList<Integer> result = subsetSums(arr, 3);
        for(Integer x : result)
            System.out.println(x);


    }



}
