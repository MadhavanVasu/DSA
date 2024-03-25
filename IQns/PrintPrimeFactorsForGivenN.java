package IQns;

import java.util.Arrays;
import java.util.Scanner;

public class PrintPrimeFactorsForGivenN {

    public static void printPrimeFactors(int N) {
        boolean[] prime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) prime[i] = true;
        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (prime[i] && N % i == 0) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printPrimeFactors(N);
    }
}
