package microsoft;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by co2y on 31/03/2017.
 */

class Node {
    public int count;
    public Node left;
    public Node right;
    public int p;
    public int deep;
    public LinkedList<Integer> ll;
    boolean flag;

    Node(int count, int p, int deep, boolean flag) {
        this.count = count;
        this.p = p;
        this.deep = deep;
        this.flag = flag;
    }
}

public class A {
    public static int P;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p, q, n;
        p = scanner.nextInt();
        P = p;
        q = scanner.nextInt();
        n = scanner.nextInt();
        Node root = new Node(0, 0, 0, false);
        root.left = new Node(1, p, 1, true);
        root.right = new Node(0, 100 - p, 1, false);
        root.ll = new LinkedList<>();
        root.left.ll = new LinkedList<>(root.ll);
        root.left.ll.add(root.left.p);
        root.right.ll = new LinkedList<>(root.ll);
        root.right.ll.add(root.right.p);
        buildTree(q, n, root.left);
        buildTree(q, n, root.right);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        double ans = 0;
        while (queue.size() > 0) {
            Node now = queue.pollFirst();
            if (now.left != null) queue.add(now.left);
            if (now.right != null) queue.add(now.right);
            if (now.count == n) {
                double temp = now.deep;
                for (int each : now.ll) {
                    temp = temp * each / 100;
                }
                ans += temp;
            }
        }
        System.out.println(String.format("%.2f", ans));
    }

    private static void buildTree(int q, int n, Node node) {
        if (node.count == n) return;
        if (!node.flag) {
            int pp = Math.min(100, node.p + q);
            node.left = new Node(node.count + 1, pp, node.deep + 1, true);
            node.left.ll = new LinkedList<>(node.ll);
            node.left.ll.add(node.left.p);
            if (pp < 100) {
                node.right = new Node(node.count, 100 - pp, node.deep + 1, false);
                node.right.ll = new LinkedList<>(node.ll);
                node.right.ll.add(node.right.p);
            }
        } else {
            int pp = P;
            for (int i = 0; i < node.count; ++i) {
                pp = P / 2;
                if (pp == 0) break;

            }
            if (pp > 0) {
                node.left = new Node(node.count + 1, pp, node.deep + 1, true);
                node.left.ll = new LinkedList<>(node.ll);
                node.left.ll.add(node.left.p);
            }
            node.right = new Node(node.count, 100 - pp, node.deep + 1, false);
            node.right.ll = new LinkedList<>(node.ll);
            node.right.ll.add(node.right.p);
        }
        if (node.left != null)
            buildTree(q, n, node.left);

        if (node.right != null)
            buildTree(q, n, node.right);
    }
}
