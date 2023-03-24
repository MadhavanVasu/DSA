package IQns;

import java.util.*;

public class GoodArray {

    public static int[] getQueryResults(int n, int[][] queries) {
        List<Integer> goodArray = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            int power = (int) (Math.log(temp) / Math.log(2));
            temp -= (Math.pow(2, power));
            goodArray.add((int) Math.pow(2, power));
        }
        goodArray.sort((o1, o2) -> {
            if (o1 > o2)
                return 1;
            else if (o1 < o2)
                return -1;
            return 0;
        });
        int product = goodArray.get(0);
        for(int i=1; i<goodArray.size(); i++)
        {
            product*=goodArray.get(i);
            goodArray.set(i, product);
        }
        int[] result = new int[queries.length];
        int i =0;
        for(int[] query : queries)
        {
            product = goodArray.get(query[1]-1)/(query[0]==1? 1 : goodArray.get(query[0]-1));
            result[i] = product%query[2];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 26;
        int[][] queries = {{1, 2, 1009}, {3, 3, 5}};
        System.out.println(Arrays.toString(getQueryResults(n, queries)));
    }

}
