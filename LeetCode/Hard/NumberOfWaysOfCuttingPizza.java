package LeetCode.Hard;

public class NumberOfWaysOfCuttingPizza {


    public static int helper(int i, int j, String[] pizza, int k, int n, int m) {
        if (k == 0) {
            System.out.println(i + " " + j);
            return 1;
        }
        int res = 0;
        for (int x = i + 1; x < n; x++) {
            int a = 0;
            for (int row = i; row < x; row++) {
                for (int col = j; col < m; col++) {
                    if (pizza[row].charAt(col) == 'A') {
                        a = 1;
                        break;
                    }
                }
            }
            if (a == 0) continue;
            res += helper(x, j, pizza, k - 1, n, m);
        }
        for (int x = j + 1; x < m; x++) {
            int a = 0;
            for (int row = i; row < n; row++) {
                for (int col = j; col < x; col++) {
                    if (pizza[row].charAt(col) == 'A') {
                        a = 1;
                        break;
                    }
                }
            }
            if (a == 0) continue;
            System.out.println();
            res += helper(i, x, pizza, k - 1, n, m);
        }
        return res;
    }

    public static int ways(String[] pizza, int k) {

        return helper(0, 0, pizza, k, pizza.length, pizza[0].length());

    }

    public static void main(String[] args) {
        String[] pizza = {"A..", "AAA", "..."};
        int k = 3;
        System.out.println(ways(pizza, k));
    }

}
