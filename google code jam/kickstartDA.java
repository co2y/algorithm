import java.util.Scanner;

public class A {
    private static int ans;
    private static int[] mimtime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            ans = -1;
            int n = scanner.nextInt();
            int ts = scanner.nextInt();
            int tf = scanner.nextInt();
            mimtime = new int[n];

            int[] s = new int[n];
            int[] f = new int[n];
            int[] d = new int[n];
            for (int i = 1; i < n; ++i) {
                s[i] = scanner.nextInt();
                f[i] = scanner.nextInt();
                d[i] = scanner.nextInt();
            }

            for (int i = n - 1; i > 0; --i) {
                if (i == n - 1)
                    mimtime[i] = getForwardTime(tf, s[i], f[i], d[i]);
                else
                    mimtime[i] = getForwardTime(mimtime[i + 1], s[i], f[i], d[i]);
            }

            dfs(0, 1, 0, n, s, f, d, ts, tf);
            if (ans == -1) System.out.println("Case #" + tt + ": IMPOSSIBLE");
            else System.out.println("Case #" + tt + ": " + ans);
        }
    }

    private static int getForwardTime(int arr, int start, int f, int d) {
        int x = arr - d;
        if (x <= start) return x;

        return ((x - start) / f) * f + start;
    }

    private static void dfs(int tmp, int pos, int now, int n, int[] s, int[] f, int[] d, int ts, int tf) {
        if (pos == n) {
            ans = Math.max(ans, tmp);
            return;
        }

        if (now > mimtime[pos]) return;
        if (ans >= tmp + (n - pos)) return;

        int time1 = getNextTime(pos, now + ts, s, f);
        int arrive1 = time1 + d[pos];
        if (arrive1 <= tf) dfs(tmp + 1, pos + 1, arrive1, n, s, f, d, ts, tf);


        int time2 = getNextTime(pos, now, s, f);
        int arrive2 = time2 + d[pos];
        if (time2 < time1 && arrive2 <= tf)
            dfs(tmp, pos + 1, arrive2, n, s, f, d, ts, tf);
    }

    private static int getNextTime(int pos, int now, int[] s, int[] f) {
        int num = (now - s[pos]) / f[pos];
        if (num < 0) return s[pos];


        int ret = s[pos] + f[pos] * num;
        if (ret < now) ret = ret + f[pos];

        return ret;
    }
}
