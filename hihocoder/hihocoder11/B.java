package hihocoder11;


import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++)
            solve();
    }

    static void solve() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int v[] = new int[n];
        int att[] = new int[n];
        int max = 1 << m;
        int d[][] = new int[n][max];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MIN_VALUE);
            d[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
            int s = scan.nextInt();
            for (int j = 0; j < s; j++) {
                int a = scan.nextInt();
                att[i] |= 1 << (a - 1);
            }
        }

        d[0][att[0]] = v[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < max; j++) {
                d[i][j] = Math.max(d[i - 1][j], d[i - 1][j ^ att[i]] + v[i]);
            }
        }

        System.out.println(d[n - 1][max - 1]);
    }
}
