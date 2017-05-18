class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l = len(nums)
        res = [1] * l
        
        for i in range(1, l):
            res[i] = res[i-1] * nums[i-1]
            
        for i in range(l-1, 0, -1):
            res[i] = res[i] * res[0]
            res[0] = res[0] * nums[i]
            
        return res