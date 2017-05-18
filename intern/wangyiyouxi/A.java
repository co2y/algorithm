package wangyiyouxi;

import java.util.Scanner;

/**
 * Created by co2y on 07/04/2017.
 */
public class A {
    static int[][] mem;
    static boolean[][] vis;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt();
        for (int ii = 0; ii < t; ++ii) {
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            mem = new int[n + 1][m + 1];
            vis = new boolean[n + 1][m + 1];
            System.out.println(dp(n, m));
        }
    }

    public static int dp(int n, int m) {
        if (vis[n][m]) return mem[n][m];
        if (n == 0) return 0;
        if (m == 1) return n;
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            int temp = Math.max(dp(i - 1, m - 1), dp(n - i, m));
            ret = Math.min(ret, temp);
        }
        vis[n][m] = true;
        mem[n][m] = ret + 1;
        return mem[n][m];
    }
}
