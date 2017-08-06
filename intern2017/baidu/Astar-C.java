package baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Created by co2y on 2017/8/5.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(
                                                     new InputStreamReader(System.in)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n, m;
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                in.nextToken();
                a[i] = (int) in.nval;
                in.nextToken();
                b[i] = (int) in.nval;
            }
            int[] k = new int[m];
            int[] p = new int[m];
            for (int i = 0; i < m; ++i) {
                in.nextToken();
                k[i] = (int) in.nval;
                in.nextToken();
                p[i] = (int) in.nval;
            }

            long[][] dp = new long[1001][11];
            for (int i = 0; i < 1001; ++i) {
                for (int j = 0; j < 11; ++j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int t = 0; t <= 10; ++t) {
                dp[0][t] = 0;
            }

            for (int t = 0; t <= 10; ++t) {
                for (int i = 0; i < m; ++i) {
                    if (p[i] <= t) continue;
                    for (int j = 1; j <= 1000; ++j) {
                        int kk = Math.max(j - (p[i] - t), 0);
                        dp[j][t] = Math.min(dp[j][t], dp[kk][t] + k[i]);
                    }
                }
            }

            long ans = 0;
            boolean flag = false;
            for (int i = 0; i < n; ++i) {
                long temp = dp[a[i]][b[i]];
                if (temp != Integer.MAX_VALUE)
                    ans += temp;
                else {
                    flag = true;
                    break;
                }
            }
            if (flag) System.out.println(-1);
            else System.out.println(ans);
        }
//        scanner.close();
    }
}


// 恰好装满

//import java.util.*;
//
///**
// * Created by co2y on 2017/8/5.
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n, m;
//            n = scanner.nextInt();
//            m = scanner.nextInt();
//            int[] a = new int[n];
//            int[] b = new int[n];
//            for (int i = 0; i < n; ++i) {
//                a[i] = scanner.nextInt();
//                b[i] = scanner.nextInt();
//            }
//            int[] k = new int[m];
//            int[] p = new int[m];
//            for (int i = 0; i < m; ++i) {
//                k[i] = scanner.nextInt();
//                p[i] = scanner.nextInt();
//            }
//
//            long[][] dp = new long[1001][11];
//            for (int i = 0; i < 1001; ++i) {
//                for (int j = 0; j < 11; ++j) {
//                    dp[i][j] = Integer.MAX_VALUE;
//                }
//            }
//            for (int t = 0; t <= 10; ++t) {
//                dp[0][t] = 0;
//            }
//            for (int t = 0; t <= 10; ++t) {
//                for (int i = 0; i < m; ++i) {
//                    if (p[i] <= t) continue;
//                    for (int j = p[i] - t; j <= 1000; ++j) {
//                        dp[j][t] = Math.min(dp[j][t], dp[j - (p[i] - t)][t] + k[i]);
//                    }
//                }
//            }
//
//            for (int i = 0; i < n; ++i)
//                if (dp[a[i]][b[i]] != Integer.MAX_VALUE)
//                    System.out.println(dp[a[i]][b[i]]);
//                else
//                    System.out.println(-1);
//
//        }
//    }
//}
