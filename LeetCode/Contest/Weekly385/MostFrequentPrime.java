package LeetCode.Contest.Weekly385;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentPrime {

    public static boolean[] prime = new boolean[1000001];

    static {
        Arrays.fill(prime, true);

        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }


    public boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public int mostFrequentPrime(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSize = (int) Math.pow(10, Math.max(n, m));
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] direction : directions) {
                    int digit = mat[i][j];
                    int x = i + direction[0];
                    int y = j + direction[1];
                    while (isValid(x, y, n, m)) {
                        digit = digit * 10 + mat[x][y];
                        if (digit > 10 && prime[digit])
                            freqMap.put(digit, freqMap.getOrDefault(digit, 0) + 1);
                        x += direction[0];
                        y += direction[1];
                    }
                }
            }
        }
        int maxFreq = 0;
        int maxNum = -1;
        for (Integer key : freqMap.keySet()) {
            if (maxFreq < freqMap.get(key)) {
                maxNum = key;
                maxFreq = freqMap.get(key);
            } else if (key > maxNum && freqMap.get(key) == maxFreq) {
                maxNum = key;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {

        System.out.println(new MostFrequentPrime().mostFrequentPrime(new int[][]{{8, 9, 3}, {3, 5, 6}, {1, 2, 5}}));

    }
}
