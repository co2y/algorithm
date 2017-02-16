public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return bs(nums, 0, right, target);

    }

    int bs(int nums[], int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return bs(nums, left, mid - 1, target);
            } else {
                return bs(nums, mid + 1, right, target);
            }
        }

        if (nums[mid] <= nums[right]) {
            if (nums[mid] < target && target <= nums[right]) {
                return bs(nums, mid + 1, right, target);
            } else {
                return bs(nums, left, mid - 1, target);
            }
        }

        return -1;
    }
}
