package microsoft;

import java.util.Scanner;

/**
 * Created by co2y on 31/03/2017.
 */
public class AAA {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int p, q, n;
        p = scanner.nextInt();
        q = scanner.nextInt();
        n = scanner.nextInt();
        double ans = 0;
        for (int i = 1; i <= n; ++i) {
            int nowp;
            if (i < 8)
                nowp = p >> (i - 1);
            else
                nowp = 0;
            double stepp = 1.0;
            int cnt = 0;
            while (true) {
                cnt++;
                if (nowp < 100)
                    ans += cnt * nowp * stepp / 100;
                else {
                    ans += stepp * cnt;
                    break;
                }
                stepp = stepp * (100 - nowp) / 100;
                nowp += q;
            }
        }
        System.out.println(String.format("%.2f", ans));
    }
}