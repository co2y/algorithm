package classic;

import java.util.Random;

/**
 * Created by co2y on 03/03/2017.
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums != null) {
            quickSort(nums, 0, nums.length - 1);
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (nums == null || start >= end) return;

        int index = partition(nums, start, end);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int r = new Random().nextInt(end - start + 1) + start;
        int pivot = nums[r];
        swap(nums, start, r);
        while (start < end) {
            while (start < end && nums[end] >= pivot) end--;
            if (start < end) swap(nums, start, end);
            while (start < end && nums[start] <= pivot) start++;
            if (start < end) swap(nums, start, end);
        }
        nums[start] = pivot;
        return start;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end || nums == null) return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];

        while (j <= end) temp[k++] = nums[j++];

        for (int xx = 0; xx < k; ++xx) {
            nums[start + xx] = temp[xx];
        }
    }

    public static void main(String args[]) {
        int[] test = {2, 4, 9, 3, 5, 7, 6, 1, 8};
        mergeSort(test);
        for (int xx : test) System.out.println(xx);
        quickSort(test);
        for (int xx : test) System.out.println(xx);
    }
}
