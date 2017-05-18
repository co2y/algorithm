class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = len(nums)
        r = 1
        count = 1
        for i in range(1, n):
            if nums[i] != nums[i - 1]:
                count = 0
                nums[r] = nums[i]
                r += 1
                count += 1
            elif count < 2:
                nums[r] = nums[i]
                r += 1
                count += 1
        return r
