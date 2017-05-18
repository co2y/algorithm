package microsoft;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by co2y on 31/03/2017.
 */
public class AA {
    public static double ans = 0;
    public static LinkedList<Integer> path = new LinkedList<>();
    public static int p, q, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextInt();
        q = scanner.nextInt();
        n = scanner.nextInt();
        path.add(p);
        dfs(p, true, 1, 1);
        path.removeLast();
        path.add(100 - p);
        dfs(100 - p, false, 1, 0);
        path.removeLast();
        System.out.println(String.format("%.2f", ans));
    }

    private static void dfs(int now, boolean flag, int deep, int count) {
        if (count == n) {
            double temp = deep;
            System.out.print(deep);
            for (int each : path) {
                temp = temp * each / 100;
                System.out.print(each);
            }
            System.out.println();
            ans += temp;
            return;
        }

        if (flag) {
            int pp = p;
            for (int i = 0; i < count; ++i) {
                pp = p / 2;
                if (pp == 0) break;

            }
            if (pp > 0) {
                path.add(pp);
                dfs(pp, true, deep + 1, count + 1);
                path.removeLast();
            }
            path.add(100 - pp);
            dfs(100 - pp, false, deep + 1, count);
            path.removeLast();
        } else {
            int pp = Math.min(100, now + q);
            path.add(pp);
            dfs(pp, true, deep + 1, count + 1);
            path.removeLast();
            if (pp < 100) {
                path.add(100 - pp);
                dfs(100 - pp, false, deep + 1, count);
                path.removeLast();
            }
        }


    }
}
