package classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by co2y on 03/04/2017.
 */
public class CmpSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 8, 7, 6, 9, 3, 4};
        Arrays.sort(a);
        printf(a);
        Arrays.sort(a);
        Integer[] b = new Integer[]{1, 3, 2, 8, 7, 6, 9, 3, 4};
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(b));

        Collections.sort(c, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Integer[] d = new Integer[c.size()];
        c.toArray(d);
        for (int xx : d) {
            System.out.print(xx);
        }
    }

    private static void printf(int[] a) {
        for (int n : a) System.out.print(n);
        System.out.println();
    }
}
