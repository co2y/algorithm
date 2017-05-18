class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        nowsum = 1
        index = ans = 0
        
        while nowsum <= n:
            if index < len(nums) and nums[index] <= nowsum:
                nowsum += nums[index]
                index += 1
            else:
                nowsum <<= 1
                ans += 1
                
        return ans