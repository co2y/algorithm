package classic;

import java.util.Scanner;
import java.io.BufferedInputStream;

class Node {  //线段树节点
    int l, r;
    long v, add;
}

public class SegmentTree {//数组实现的二叉线段树

    static int N = 100005;
    Node node[] = new Node[N * 3];
    long sum[];


    public SegmentTree(long[] sum) {
        this.sum = sum;
        for (int i = 0; i < 3 * N; i++)
            node[i] = new Node();
    }

    public int L(int u) {
        return u << 1;
    }

    public int R(int u) {
        return u << 1 | 1;
    }

    public void build(int u, int l, int r)  //建以r为根的线段树[l,r]
    {
        node[u].l = l;
        node[u].r = r;
        node[u].add = 0;
        node[u].v = sum[r] - sum[l - 1];
        if (l == r) return;
        int mid = (l + r) >> 1;
        build(L(u), l, mid);
        build(R(u), mid + 1, r);
    }

    public void update(int u, int l, int r, int val)  //更新
    {
        if (l == node[u].l && node[u].r == r) {
            node[u].add += val;
            node[u].v += val * (r - l + 1);
            return;
        }

        if (node[u].add != 0) {
            node[L(u)].add += node[u].add;
            node[L(u)].v += node[u].add * (node[L(u)].r - node[L(u)].l + 1);
            node[R(u)].add += node[u].add;
            node[R(u)].v += node[u].add * (node[R(u)].r - node[R(u)].l + 1);
            node[u].add = 0;
        }

        int mid = (node[u].l + node[u].r) >> 1;
        if (r <= mid)
            update(L(u), l, r, val);
        else if (l > mid)
            update(R(u), l, r, val);
        else {
            update(L(u), l, mid, val);
            update(R(u), mid + 1, r, val);
        }
        node[u].v = node[L(u)].v + node[R(u)].v;
    }

    public long query(int u, int l, int r)  //查询
    {
        if (l == node[u].l && node[u].r == r)
            return node[u].v;

        if (node[u].add != 0) {
            node[L(u)].add += node[u].add;
            node[L(u)].v += node[u].add * (node[L(u)].r - node[L(u)].l + 1);
            node[R(u)].add += node[u].add;
            node[R(u)].v += node[u].add * (node[R(u)].r - node[R(u)].l + 1);
            node[u].add = 0;
        }

        int mid = (node[u].l + node[u].r) >> 1;  // 计算左右子结点的分隔点
        if (r <= mid)
            return query(L(u), l, r);  // 和左孩子有交集，考察左子结点
        else if (l > mid)
            return query(R(u), l, r);  // 和右孩子有交集，考察右子结点
        else
            return query(L(u), l, mid) + query(R(u), mid + 1, r);
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int n = in.nextInt();
        int m = in.nextInt();

        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + in.nextInt();
        }

        SegmentTree st = new SegmentTree(sum);
        st.build(1, 1, n);
        //st.printTree(1);
        String cmd;
        int x;
        int y;
        int c;
        for (int i = 0; i < m; i++) {
            cmd = in.next();
            if (cmd.equals("Q")) {
                x = in.nextInt();
                y = in.nextInt();
                System.out.println(st.query(1, x, y));
            } else {
                x = in.nextInt();
                y = in.nextInt();
                c = in.nextInt();
                // System.out.println("c="+c);
                st.update(1, x, y, c);
            }
        }

    }

}
