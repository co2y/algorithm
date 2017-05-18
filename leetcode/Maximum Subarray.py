class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        ret = float('-inf')
        for num in nums:
            if ans < 0:
                ans = 0
            if num <= 0 and ans==0:
                ret = max(num,ret)
                continue
            else:
                ans = num+ans
                if num > 0:
                    ret = max(ans,ret)

        return ret
