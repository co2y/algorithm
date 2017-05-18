package hihocoder11;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by co2y on 26/03/2017.
 */
public class C {

    static int[] father = new int[1000000];
    static HashSet<Integer> hs = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[][] used = new boolean[1000][1000];
        for (int i = 0; i < 1000000; ++i) {
            father[i] = i;
        }
        int c = 0, s = 0, r = 0;
        for (int nn = 0; nn < n; ++nn) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (used[x][y]) {
                System.out.println(c + " " + s + " " + r);
            } else {
                used[x][y] = true;
                s += 1;
                hs.clear();
                int temp = check(used, x, y);
                if (temp == 0) r += 4;
                else if (temp == 1) r += 2;
                else if (temp == 3) r -= 2;
                else if (temp == 4) r -= 4;

                int f = x * 1000 + y;
                for (int xx : hs) {
                    father[xx] = f;
                }
                c = c + 1 - hs.size();
                System.out.println(c + " " + s + " " + r);
            }
        }
    }

    private static int check(boolean[][] used, int x, int y) {
        int temp = 0;
        if (x - 1 >= 0 && used[x - 1][y]) {
            temp++;
            hs.add(find((x - 1) * 1000 + y));
        }
        if (x + 1 < 1000 && used[x + 1][y]) {
            temp++;
            hs.add(find((x + 1) * 1000 + y));
        }
        if (y - 1 >= 0 && used[x][y - 1]) {
            temp++;
            hs.add(find(x * 1000 + (y - 1)));
        }
        if (y + 1 < 1000 && used[x][y + 1]) {
            temp++;
            hs.add(find(x * 1000 + (y + 1)));
        }
        return temp;
    }

    static int find(int x) {
        if (x != father[x]) {
            father[x] = find(father[x]);
        }
        return father[x];
    }

}
