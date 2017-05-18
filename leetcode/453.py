class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        ans = 0
        diff = 0
        l = len(nums)
        for i in range(1, l):
            diff = diff + nums[i] - nums[i - 1]
            ans = ans + diff
        return ans
