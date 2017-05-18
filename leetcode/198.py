class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        l = len(nums)
        dp = []
        for i in range(l):
            dp.append([0,0])
            
        dp[0][0] = 0
        dp[0][1] = nums[0]
        
        for i in range(1,l):
            dp[i][0] = dp[i-1][1]
            dp[i][1] = max(dp[i-1][0]+nums[i],dp[i-1][1])
        
        return max(dp[l-1][0],dp[l-1][1])
        
        