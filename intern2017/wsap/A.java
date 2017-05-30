package me.co2y.intern.wsap;

import java.util.Scanner;

/**
 * Created by co2y on 2017/5/29.
 */
public class A {
    private static int MOD = 10000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(solve(n, k));
    }

    public static int solve(int n, int k) {
        int[][] dp = new int[1001][1001];
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                for (int kk = Math.max(j - i + 1, 0); kk <= Math.min(j, (i - 1) * i / 2); ++kk) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][kk]) % MOD;
                }
            }
        }

        return dp[n][k];
    }
}