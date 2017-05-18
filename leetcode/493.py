class Solution(object):
    def reversePairs(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        self.ans = 0

        def merge_sort(start, end):
            if start >= end:
                return

            mid = start + (end - start) / 2
            merge_sort(start, mid)
            merge_sort(mid + 1, end)

            first = start
            second = mid + 1

            while first <= mid and second <= end:
                if nums[first] <= 2 * nums[second]:
                    first += 1
                else:
                    self.ans += mid + 1 - first
                    second += 1

            nums[start:end + 1] = sorted(nums[start:end + 1])

        merge_sort(0, l - 1)
        return self.ans
