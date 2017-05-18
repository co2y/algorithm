public class Solution {
    private int ans;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int step, int sum, int target) {
        if (step == nums.length) {
            if (sum == target)
                ans++;
            return;
        }
        dfs(nums, step+1, sum+nums[step], target);
        dfs(nums, step+1, sum-nums[step], target);
    }
}
