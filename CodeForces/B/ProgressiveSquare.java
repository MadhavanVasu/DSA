package CodeForces.B;

import java.util.*;

public class ProgressiveSquare {

    public static String findIfValidProgressiveSquare(int n, int c, int d, List<Integer> num) {
        if (num.size() != n * n) return "No";
        int[][] matrix = new int[n][n];
        Map<Integer, Integer> freqMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int x : num) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
            min = Math.min(min, x);
        }
        matrix[0][0] = min;
        freqMap.put(min, freqMap.get(min) - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int ele = 0;
                if (j == 0) ele = matrix[j][i - 1] + d;
                else if (i == 0) {
                    ele = matrix[j - 1][i] + c;
                }
                else {
                    if (matrix[j - 1][i] + c == matrix[j][i - 1] + d) {
                        ele = matrix[j - 1][i] + c;
                    } else return "No";
                }
                if (freqMap.containsKey(ele) && freqMap.get(ele) > 0) {
                    freqMap.put(ele, freqMap.get(ele) - 1);
                    matrix[j][i] = ele;
                }
                else return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            List<Integer> num = new ArrayList<>();
            for (int j = 0; j < n * n; j++) {
                int ele = sc.nextInt();
                num.add(ele);
            }
            System.out.println(findIfValidProgressiveSquare(n, c, d, num));
        }
    }
}

// 3 2 3
// 1 3 4 5 6 7 8 9 10
