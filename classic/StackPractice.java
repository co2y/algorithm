package classic;

/**
 * Created by co2y on 05/04/2017.
 */
public class StackPractice {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 8, 6, 5, 9, 7, 4};
        int k = 5;
        int len = 0;
        int[] res = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            while (len > 0 && (nums.length - i > k - len) && res[len - 1] < nums[i]) len--;
            if (len < k) {
                res[len++] = nums[i];
            }
        }
        for (int i = 0; i < k; ++i) {
            System.out.print(res[i]);
        }
    }
}
