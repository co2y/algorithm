class Solution(object):

    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        r = 1
        n = len(nums)
        for i in range(1, n):
            if nums[i] != nums[i - 1]:
                nums[r] = nums[i]
                r = r + 1
        return r
