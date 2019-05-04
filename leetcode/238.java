class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                p[i] = nums[i] * p[i-1];
            } else {
                p[i] = nums[i];
            }
        }
        
        int[] rp = new int[n];
        for (int i = n-1; i >= 0; --i) {
            if (i < n - 1) {
                rp[i] = nums[i] * rp[i+1];
            } else {
                rp[i] = nums[i];
            }
        }
        
        int ans[] = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                ans[i] = rp[i+1];
            } else if (i == n-1) {
                ans[i] = p[i-1];
            } else {
                ans[i] = p[i-1] * rp[i+1];    
            }
            
        }
        return ans;
    }
}