import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by co2y on 16/02/2017.
 */
public class hiho137 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int q = scanner.nextInt();
        while (q-- != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int t = scanner.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            for (int i = 0; i < m; ++i) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; ++i) {
                b[i] = scanner.nextInt();
            }

            long ans = 0;
            boolean find = true;

            while (n-- != 0) {
                long[] f = new long[k + 1];
                Arrays.fill(f, Integer.MAX_VALUE);
                f[0] = 0;
                for (int i = 0; i < m; ++i) {
                    if (b[i] == 0) {
                        continue;
                    }
                    for (int y = 0; y < k + 1; ++y) {
                        int x = y + b[i];
                        f[Math.min(k, x)] = Math.min(f[Math.min(k, x)], f[y] + a[i]);
                    }
                }
                if (f[k] != Integer.MAX_VALUE) {
                    ans += f[k];
                } else {
                    find = false;
                    break;
                }
                for (int i = 0; i < m; ++i) {
                    b[i] = b[i] / t;
                }
            }
            if (find) {
                System.out.println(ans);
            } else {
                System.out.println("No Answer");
            }
        }
    }
}
