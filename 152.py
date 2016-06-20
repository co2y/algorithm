class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = nowmax = nowmin = nums[0]
        
        for each in nums[1:]:
            if each < 0:
                nowmax, nowmin = nowmin, nowmax
                
            nowmax = max(nowmax*each, each)
            nowmin = min(nowmin*each, each)
            
            ans = max(ans, nowmax)
            
        return ans