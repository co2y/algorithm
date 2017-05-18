package hihocoder9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by co2y on 12/03/2017.
 */
public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] graph = new char[n][m];
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String line = scanner.next();
            graph[i] = line.toCharArray();
        }

        LinkedList<int[]> ll = new LinkedList<>();

        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (graph[i][j] == '0') {
                    used[i][j] = true;
                    ans[i][j] = 0;
                    ll.add(new int[]{i, j});
                }
            }
        }

        while (ll.size() > 0) {
            int[] temp = ll.getFirst();
            ll.removeFirst();
            int nowi = temp[0];
            int nowj = temp[1];

            setaround(nowi, nowj, n, m, ans, used, ll);


//            ArrayList<int[]> al = new ArrayList<>();
//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < m; ++j) {
//                    if (!used[i][j] && getround(i, j, n, m, used)) {
//                        change = true;
//                        ans[i][j] = getmin(i, j, n, m, ans) + 1;
//                        al.add(new int[]{i, j});
//                    }
//                }
//            }

//            for (int[] a : al) {
//                used[a[0]][a[1]] = true;
//            }
//            al.clear();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void setaround(int i, int j, int n, int m, int[][] ans, boolean[][] used, LinkedList<int[]> ll) {
        if (i - 1 >= 0 && !used[i - 1][j]) {
            ans[i - 1][j] = ans[i][j] + 1;
            used[i - 1][j] = true;
            ll.add(new int[]{i - 1, j});
        }
        if (i + 1 < n && !used[i + 1][j]) {
            ans[i + 1][j] = ans[i][j] + 1;
            used[i + 1][j] = true;
            ll.add(new int[]{i + 1, j});
        }
        if (j - 1 >= 0 && !used[i][j - 1]) {
            ans[i][j - 1] = ans[i][j] + 1;
            used[i][j - 1] = true;
            ll.add(new int[]{i, j - 1});
        }
        if (j + 1 < m && !used[i][j + 1]) {
            ans[i][j + 1] = ans[i][j] + 1;
            used[i][j + 1] = true;
            ll.add(new int[]{i, j + 1});
        }
    }

    private static int getmin(int i, int j, int n, int m, int[][] ans) {
        int temp = 2000;
        if (i - 1 > 0) temp = Math.min(temp, ans[i - 1][j]);
        if (i + 1 < n) temp = Math.min(temp, ans[i + 1][j]);
        if (j - 1 > 0) temp = Math.min(temp, ans[i][j - 1]);
        if (j + 1 < m) temp = Math.min(temp, ans[i][j + 1]);

        return temp;
    }

    private static boolean getround(int i, int j, int n, int m, boolean[][] used) {
        if (i - 1 > 0 && used[i - 1][j]) return true;
        if (i + 1 < n && used[i + 1][j]) return true;
        if (j - 1 > 0 && used[i][j - 1]) return true;
        if (j + 1 < m && used[i][j + 1]) return true;

        return false;
    }


}
