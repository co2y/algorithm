package classic; /**
 * Created by co2y on 28/03/2017.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class spfa {

    public long[] dis;         //用于得到第s个顶点到其它顶点之间的最短距离

    public static ArrayList<LinkedList<edge>> adjList;
    public static int[] path;

    //内部类，用于存放图的具体边数据
    static class edge {
        public int from;  //边的起点
        public int to;  //边的终点
        public int weight;   //边的权值
        public edge next;

        edge(int a, int b, int value) {
            this.from = a;
            this.to = b;
            this.weight = value;
        }
    }

    /*
     * 参数n:给定图的顶点个数
     * 参数s:求取第s个顶点到其它所有顶点之间的最短距离
     * 参数edge:给定图的具体边
     * 函数功能：如果给定图不含负权回路，则可以得到最终结果，如果含有负权回路，则不能得到最终结果
     */
    public boolean getShortestPaths(int n, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        dis = new long[n];
        boolean[] used = new boolean[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
            used[i] = false;
        }

        dis[s] = 0;     //第s个顶点到自身距离为0
        used[s] = true;    //表示第s个顶点进入数组队
        num[s] = 1;       //表示第s个顶点已被遍历一次
        queue.addLast(s);      //第s个顶点入队
        while (queue.size() != 0) {
            int a = queue.pollFirst();   //获取并删除数组队中第一个元素
            for (int i = 0; i < adjList.get(a).size(); i++) {
                //当list数组队的第一个元素等于边A[i]的起点时

                edge e = adjList.get(a).get(i);
                if (dis[e.to] > dis[e.from] + e.weight) {
                    dis[e.to] = dis[e.from] + e.weight;
                    path[e.to] = e.from;
                    if (!used[e.to]) {
                        queue.add(e.to);
                        num[e.to]++;
                        if (num[e.to] > n)
                            return false;
                        used[e.to] = true;   //表示边A[i]的终点b已进入数组队
                    }
                }
            }
            used[a] = false;        //顶点a出数组对
        }
        return true;
    }

    public static void main(String[] args) {
        spfa test = new spfa();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个图的顶点总数n起点下标s和边总数p：");
        int n = in.nextInt();
        int s = in.nextInt();
        int p = in.nextInt();
        adjList = new ArrayList<>();
        path = new int[n];
        System.out.println("请输入具体边的数据：");
        for (int i = 0; i < n; ++i) {
            adjList.add(new LinkedList<>());
        }
        for (int i = 0; i < p; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            adjList.get(a).add(new edge(a, b, value));
        }
        if (test.getShortestPaths(n, s)) {
            for (int i = 0; i < test.dis.length; i++)
                System.out.print(test.dis[i] + " ");
        } else
            System.out.println("给定图存在负环，没有最短距离");

        printPath(5);
    }

    private static void printPath(int s) {
        if (path[s] != 0) printPath(path[s]);
        System.out.print(s + "->");
    }
}
