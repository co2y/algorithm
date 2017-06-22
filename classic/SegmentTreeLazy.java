package classic;

import java.util.Scanner;

/**
 * Created by co2y on 22/06/2017.
 */


public class SegmentTreeLazy {
    private static Scanner scanner = new Scanner(System.in);

    static class Node {
        int l, r;

        int mid() {
            return (l + r) >> 1;
        }
    }

    private static final int N = 100005;
    private static int[] sum = new int[N << 2];
    private static int[] add = new int[N << 2];

    private static Node[] tree = new Node[N << 2];

    static {
        for (int i = 0; i < N << 2; ++i) {
            tree[i] = new Node();
        }
    }

    private void pushUp(int rt) {
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    private void pushDown(int rt, int m) {
        if (add[rt] > 0) {
            add[rt << 1] += add[rt];
            add[rt << 1 | 1] += add[rt];
            sum[rt << 1] += add[rt] * (m - (m >> 1));
            sum[rt << 1 | 1] += add[rt] * (m >> 1);
            add[rt] = 0;
        }
    }

    private void build(int l, int r, int rt) {
        tree[rt].l = l;
        tree[rt].r = r;
        add[rt] = 0;
        if (l == r) {
            sum[rt] = scanner.nextInt();
            return;
        }

        int m = tree[rt].mid();
        build(l, m, rt << 1);
        build(m + 1, r, rt << 1 | 1);
        pushUp(rt);
    }

    private void update(int c, int l, int r, int rt) {
        if (tree[rt].l == l && tree[rt].r == r) {
            add[rt] += c;
            sum[rt] += (long) c * (r - l + 1);
            return;
        }
        if (tree[rt].l == tree[rt].r) return;

        pushDown(rt, tree[rt].r - tree[rt].l + 1);
        int m = tree[rt].mid();
        if (r <= m) update(c, l, r, rt << 1);
        else if (l > m) update(c, l, r, rt << 1 | 1);
        else {
            update(c, l, m, rt << 1);
            update(c, m + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    private int query(int l, int r, int rt) {
        if (l == tree[rt].l && r == tree[rt].r) return sum[rt];

        pushDown(rt, tree[rt].r - tree[rt].l + 1);

        int m = tree[rt].mid();

        int res = 0;
        if (r <= m) res += query(l, r, rt << 1);
        else if (l > m) res += query(l, r, rt << 1 | 1);
        else {
            res += query(l, m, rt << 1);
            res += query(m + 1, r, rt << 1 | 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n, m;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            SegmentTreeLazy stl = new SegmentTreeLazy();

            stl.build(1, n, 1);
            for (int i = 0; i < m; ++i) {
                String ch = scanner.next();
                int a, b, c;
                if (ch.startsWith("Q")) {
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    System.out.println(stl.query(a, b, 1));
                } else {
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    c = scanner.nextInt();
                    stl.update(c, a, b, 1);
                }
            }

        }
    }

}
