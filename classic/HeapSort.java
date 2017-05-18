package classic;

/**
 * Created by co2y on 16/04/2017.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 9, 8, 7, 3, 2, 1};
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; --i) {
            heapPushDown(a, i, n);
        }

        for (int i = n - 1; i > 0; --i) {
            swap(a, i, 0);
            heapPushDown(a, 0, i);
        }

        for (int aa : a) {
            System.out.print(aa);
        }
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }

    private static void heapPushDown(int[] a, int i, int n) {
        int j = 2 * i + 1;
        int temp = a[i];
        while (j < n) {
            if (j + 1 < n && a[j + 1] < a[j]) {
                j++;
            }

            if (a[j] > temp) break;

            a[i] = a[j];
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }
}
