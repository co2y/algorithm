//package microsoft;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.Scanner;
//
///**
// * Created by co2y on 31/03/2017.
// */
//public class B {
//    class Node {
//        int val;
//        int deep;
//
//        Node(int val, int deep) {
//            this.val = val;
//            this.deep = deep;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n, m, k;
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        k = scanner.nextInt();
//        int[] a = new int[m];
//        for (int i = 0; i < m; ++i) {
//            a[i] = scanner.nextInt();
//        }
//        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
//        for (int i = 0; i < m; ++i) {
//            nodes.add(new ArrayList<>());
//            for (int j = 0; j < a[i]; ++j) {
//                nodes.get(i).add(scanner.nextInt());
//            }
//        }
//        int[] leaves = new int[k];
//        HashSet<Integer> hs = new HashSet<>();
//        for (int i = 0; i < k; ++i) {
//            int lea = scanner.nextInt();
//            leaves[i] = lea;
//            hs.add(lea);
//        }
//        int[][] dis = new int[n + 1][n + 1];
//        for (int i = 1; i <= k; ++i) {
//            for (int j = 1; j <= k; ++j) {
//                dis[leaves[i - 1]][leaves[j - 1]] = scanner.nextInt();
//            }
//        }
//
//        int[] father = new int[n + 1];
//
//        for (int i = nodes.size() - 1; i >= 0; --i) {
//            if (i == 0) {
//                for (int node : nodes.get(i)) {
//                    father[node] = 0;
//                }
//            } else {
//                dfs(nodes.get(i), nodes.get(i - 1), hs, father, -1);
//            }
//        }
//
//    }
//
//    private static void dfs(ArrayList<Integer> integers, ArrayList<Integer> integers1, HashSet<Integer> hs, int[] father, int pre) {
//
//        if (find) return;
//        if (integers.size()==0 && integers1.size()==0){find=true;}
//        if ()
//
//        for (int upper : integers1) {
//            if (hs.contains(upper)) continue;
//
//            for (int under: integers) {
//                if (pre == -1 || dis[under])
//                    father[under] = upper;
//
//            }
//        }
//
//    }
//}
