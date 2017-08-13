package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by co2y on 2017/8/12.
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; ++i) x[i] = scanner.nextInt();
        for (int i = 0; i < n; ++i) y[i] = scanner.nextInt();

        int[][] dis = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int d = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                dis[i][j] = d;
                dis[j][i] = d;
            }
        }

        int[][] ans = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.sort(dis[i]);
            for (int j = 1; j < n; ++j) {
                ans[i][j] = ans[i][j - 1] + dis[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                min = Math.min(min, ans[j][i]);
            }
            sb.append(min);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
