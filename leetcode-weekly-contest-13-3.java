public class Solution {
    private boolean[] used = new boolean[16];
    public boolean makesquare(int[] nums) {
        int sum=0;

        for (int i=0; i<nums.length; ++i){
            sum += nums[i];
            used[i] = false;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int temp = sum / 4;
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length-1, 0, temp);
    }
    public boolean dfs(int nums[], int findnum, int now, int sum, int len){

        if (findnum == 3){
            return true;
        }
        for (int i=now; i>=0; --i){
            if (nums[i] > len) {
                return false;
            }
            if (used[i]) continue;
            if (sum + nums[i] < len){
                used[i] = true;
                if (dfs(nums, findnum, now-1, sum+nums[i], len))
                    return true;
                used[i] =false;
            }
            if (sum + nums[i] == len){

                used[i] = true;
                if (dfs(nums, findnum+1, nums.length-1, 0, len))
                    return true;
                used[i] = false;
            }

            if (sum == 0) break;
        }
        return false;
    }
}
