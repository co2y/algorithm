class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        k = len(nums) - k
        left = 0
        right = len(nums) - 1
        while left < right:
            pivot = self.partition(nums, left, right)
            if pivot < k:
                left = pivot + 1
            elif pivot > k:
                right = pivot - 1
            else:
                break
        return nums[k]

    def partition(self, nums, left, right):
        i = left + 1
        j = right
        while 1:
            while i < right and nums[i] <= nums[left]:
                i += 1
            while j > left and nums[j] >= nums[left]:
                j -= 1
            if i >= j:
                break
            nums[i], nums[j] = nums[j], nums[i]

        nums[left], nums[j] = nums[j], nums[left]
        return j
