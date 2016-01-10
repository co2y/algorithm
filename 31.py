class Solution(object):

    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        idx = len(nums) - 2
        # 1. find out the last wrong order
        while idx >= 0 and nums[idx] >= nums[idx + 1]:
            idx -= 1
        # 2. swap
        if idx >= 0:
            i = idx + 1
            while i < len(nums) and nums[i] > nums[idx]:
                i += 1
            nums[i - 1], nums[idx] = nums[idx], nums[i - 1]

        # 3. reverse
        left, right = idx + 1, len(nums) - 1
        while left <= right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
