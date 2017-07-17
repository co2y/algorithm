
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int n, kk, c, d, e1, e2, f;
            n = scanner.nextInt();
            kk = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];
            a[0] = scanner.nextInt();
            b[0] = scanner.nextInt();

            c = scanner.nextInt();
            d = scanner.nextInt();
            e1 = scanner.nextInt();
            e2 = scanner.nextInt();
            f = scanner.nextInt();


            int r = 0, s = 0;
            System.out.println(a[0] + " " + b[0]);
            for (int i = 1; i < n; ++i) {
                a[i] = (c * a[i - 1] + d * b[i - 1] + e1) % f;

                b[i] = (d * a[i - 1] + c * b[i - 1] + e2) % f;


                int r0 = r, s0 = s;
                r = (c * r0 + d * s0 + e1) % 2;
                s = (d * r0 + c * s0 + e2) % 2;


                if ((r & 1) == 1) a[i] = -a[i];
                if ((s & 1) == 1) b[i] = -b[i];
                System.out.println(a[i] + " " + b[i]);
            }


            int matrix[][] = new int[n][n];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = a[i] * b[j];
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            int total = n * (n + 1) / 2 * n * (n + 1) / 2;
            long[] sums = new long[total];
            int count = 0;


            int[][] p = new int[n + 1][n + 1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            for (int i = 1; i <= n; ++i) {
                for (int k = 1; k <= n; ++k) {
                    for (int j = i; j <= n; ++j) {

                        for (int m = k; m <= n; ++m) {
                            long sum = p[j][m] - p[j][k - 1] - p[i - 1][m] + p[i - 1][k - 1];
                            sums[count] = sum;
                            count++;
                        }
                    }
                }
            }


            System.out.println("Case #" + tt + ": " + findk(kk, sums, 0, total - 1));
        }
    }

    private static int partition(long[] a, int low, int high) {

        long pivot = a[low];
        while (low < high) {
            while (low < high && a[high] <= pivot)
                high--;
            a[low] = a[high];

            while (low < high && a[low] >= pivot)
                low++;
            a[high] = a[low];
        }

        a[low] = pivot;
        return low;
    }


    static long findk(int k, long[] a, int low, int high) {
        int pos = partition(a, low, high);
        int num = pos - low + 1;
        if (num == k) {
            return a[pos];
        } else if (k < num)
            return findk(k, a, low, pos - 1);
        else
            return findk(k - num, a, pos + 1, high);
    }
}