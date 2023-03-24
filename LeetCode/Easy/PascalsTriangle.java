package Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        if(numRows == 1 )
        {
            List<Integer> list = List.of(1);
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        List<Integer> list1 = List.of(1);
        List<Integer> list2 = List.of(1,1);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        for(int i=2 ; i<numRows; i++)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; j<i; j++)
            {
                int ele = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                temp.add(ele);
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));

    }
}
