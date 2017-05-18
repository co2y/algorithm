package hihocoder;

import java.util.Scanner;

/**
 * Created by co2y on 05/03/2017.
 */
public class D {
    public static void main(String[] args) {
        int n, m, k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int[][] a = new int[k][2];
        for (int i = 0; i < k; ++i) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }

        long ans = (long) (n + 1) * n * (m + 1) * m / 4;

        for (int code = 1; code < (1 << k); ++code) {
            int l = m, r = 0, u = n, d = 0, cnt = 0;
            for (int i = 0; i < k; ++i) {
                if ((code & (1 << i)) != 0) {
                    l = Math.min(l, a[i][1]);
                    r = Math.max(r, a[i][1]);
                    u = Math.min(u, a[i][0]);
                    d = Math.max(d, a[i][0]);

                    cnt++;
                }
            }

            if (cnt % 2 == 0) ans += (long) l * u * (m - r + 1) * (n - d + 1);
            else ans -= (long) l * u * (m - r + 1) * (n - d + 1);
        }

        System.out.println(ans);
    }
}
