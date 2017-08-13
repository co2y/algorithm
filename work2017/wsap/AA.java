package me.co2y.intern.wsap;

import java.util.Scanner;

/**
 * Created by co2y on 2017/5/29.
 */
public class AA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[][] f = new int[1001][1001];
        int mod = 10000;
        for (int i = 1; i <= n; i++) f[i][0] = 1;
        for (int i = 2; i <= n; i++) {
            int t = f[i - 1][0];
            for (int j = 1; j <= k; j++) {
                if (j - i >= 0) t -= f[i - 1][j - i];
                t += f[i - 1][j];
                f[i][j] = (t + mod) % mod;
            }
        }
        System.out.println(f[n][k]);
    }
}
