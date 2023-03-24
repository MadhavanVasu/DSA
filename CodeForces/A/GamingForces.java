package CodeForces.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class GamingForces {

    public static int findMinSpells(int n, int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int count = 0;
        while (i < n) {
            if (i + 1 < n) {
                if (arr[i] == arr[i + 1] && arr[i] == 1) {
                    count += 1;
                    i += 2;
                } else {
                    count += 2;
                    i += 2;
                }
            } else {
                i += 1;
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String line = br.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(strs[j]);
            }
            System.out.println(findMinSpells(n, arr));

        }

    }

}
