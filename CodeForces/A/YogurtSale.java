package CodeForces.A;

import java.io.IOException;
import java.util.Scanner;

public class YogurtSale {
    public static int findMinimumCost(int n, int a, int b) {
        int pairs = n / 2;
        if (a * 2 < b) return a * n;
        return pairs * b + (n % 2) * a;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(findMinimumCost(n, a, b));
        }
    }
}
