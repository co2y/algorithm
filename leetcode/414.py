class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        nums = list(set(nums))
        if len(nums) <= 2:
            return max(nums)

        def partition(low, high):
            pivot = nums[low]
            while low < high:
                while low < high and nums[high] < pivot:
                    high -= 1
                nums[low] = nums[high]

                while low < high and nums[low] > pivot:
                    low += 1
                nums[high] = nums[low]

            nums[low] = pivot
            return low

        def quicksort(low, high, k):
            if low >= high:
                return

            index = partition(low, high)

            if index > k:
                quicksort(low, index - 1, k)
            elif index < k:
                quicksort(low + 1, high, k)
            else:
                return

        quicksort(0, len(nums) - 1, 2)
        return nums[2]
