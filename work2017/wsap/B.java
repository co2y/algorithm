package me.co2y.intern.wsap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by co2y on 2017/5/29.
 */
public class B {
    private static boolean find = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] a = new int[n];
        long ss = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt() % m;
            ss += a[i];
        }

        if (ss < m) {
            System.out.println("No");
            return;
        }

        dfs(a, 0, 0, m, n);

        if (find) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void dfs(int[] a, int now, long sum, int m, int n) {
        if (find) {
            return;
        }

        if (now != 0 && sum % m == 0) {
            find = true;
            return;
        }

        for (int i = now; i < n; ++i) {
            dfs(a, i + 1, sum + a[i], m, n);
        }

    }
}
