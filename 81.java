public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return bs(nums, 0, right, target);

    }

    boolean bs(int nums[], int left, int right, int target) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return true;
        }

        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return bs(nums, left, mid - 1, target);
            } else {
                return bs(nums, mid + 1, right, target);
            }
        }

        else if (nums[mid] < nums[right]) {
            if (nums[mid] < target && target <= nums[right]) {
                return bs(nums, mid + 1, right, target);
            } else {
                return bs(nums, left, mid - 1, target);
            }
        }

        else if (nums[left] == nums[mid])
            return bs(nums, left+1, right, target);

        else
            return bs(nums, left, right-1, target);
    }
}
