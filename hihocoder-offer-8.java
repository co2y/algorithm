

import java.util.Scanner;

/**
 * Created by co2y on 05/03/2017.
 */
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T;
        T = scanner.nextInt();
        for (int i = 0; i < T; ++i) {
            long l, f, d;
            l = scanner.nextLong();
            f = scanner.nextLong();
            d = scanner.nextLong();
            if (f > l) {
                System.out.println("NO");
                continue;
            }

            if (f == l) {
                if (d % l == 0) System.out.println("YES");
                else System.out.println("NO");
                continue;
            }

            d = d % l;
            long temp = d;

            boolean flag = true;
            for (long j = 1; j <= l; ++j) {

                if (j != 1 && temp == j*d%l) break;

                if ((j * d) / l == (j * d + f) / l)
                    continue;


                System.out.println("NO");
                flag = false;
                break;

            }

            if (flag)
                System.out.println("YES");
        }
    }
}




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by co2y on 05/03/2017.
 */
public class Main {

    private static int n, m;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        boolean[][] used = new boolean[n][m];

        char[][] word = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                word[i][j] = line.charAt(j);
            }
        }

        ArrayList<Point> aaa = new ArrayList<>();

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (word[i][j] == '1' && used[i][j] == false) {
                    dfs(word, i, j, used, aaa);
                    myprint(word, aaa);
                    aaa.clear();
                }
            }
        }

    }

    private static void myprint(char[][] word, ArrayList<Point> aaa) {
        int left = 600, right = -1, up = 600, down = -1;
        for (Point p : aaa) {
            if (p.x < up) up = p.x;
            if (p.x > down) down = p.x;
            if (p.y < left) left = p.y;
            if (p.y > right) right = p.y;
        }

        int x = down - up;
        int y = right - left;
        char[][] pp = new char[x + 1][y + 1];
        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                pp[i][j] = '0';
            }
        }
        for (Point p : aaa) {
            pp[p.x - up][p.y - left] = '1';
        }

        System.out.println((x+1) + " " + (y+1));
        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                System.out.print(pp[i][j]);
            }
            System.out.println();
        }
    }

    static class Point {
        public int x;
        public int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static void dfs(char[][] word, int i, int j, boolean[][] used, ArrayList aaa) {
        if (i >= n || j >= m || i < 0 || j < 0) return;

        if (used[i][j] == false && word[i][j] == '1') {
            used[i][j] = true;
            aaa.add(new Point(i, j));
            dfs(word, i + 1, j, used, aaa);
            dfs(word, i - 1, j, used, aaa);
            dfs(word, i, j + 1, used, aaa);
            dfs(word, i, j - 1, used, aaa);
        }

    }
}
