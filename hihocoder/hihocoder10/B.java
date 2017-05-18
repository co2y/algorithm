package hihocoder10;

import java.util.Scanner;

/**
 * Created by co2y on 19/03/2017.
 */
public class B {
    public static void main(String[] args) {
        int N;
        int MOD = 1000000007;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[][] dp = new int[100001][7];
        dp[0][0] = 1; // O -A
        dp[0][1] = 0; // O +A
        dp[0][2] = 1; // L -L -A
        dp[0][3] = 0; // L -L +A
        dp[0][4] = 0; // L +L -A
        dp[0][5] = 0; // L +L +A
        dp[0][6] = 1; // A
        for (int i = 1; i < N; ++i) {

        }

    }
}
