class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % k != 0) return false;
        
        int target = sum / k;
        
        boolean[] vis = new boolean[nums.length];
        
        Arrays.sort(nums);
        return dfs(nums, vis, target, 0, k, 0);
    }
    
    boolean dfs(int[] nums, boolean[] vis, int target, int now, int k, int next) {
        if (k == 1) return true;
        
        for (int i = next; i < nums.length; ++i) {
            if (nums[i] > target - now) break;
            
            if (!vis[i]) {    
                vis[i] = true;
                if (nums[i] == target - now) {
                    if (dfs(nums, vis, target, 0, k-1, 0)) return true;
                } else {
                    if (dfs(nums, vis, target, now + nums[i], k, i+1)) return true;
                }
                vis[i] = false;
            }
        }
        
        return false;

    }
}