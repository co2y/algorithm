class Solution(object):

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ret = [-1, -1]
        length = len(nums)
        left = 0
        right = length - 1
        while left <= right:
            if nums[left] == target and nums[right] == target:
                ret[0] = left
                ret[1] = right
                break

            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                if nums[left] == target:
                    right -= 1
                elif nums[right] == target:
                    left += 1
                else:
                    right -= 1
                    left += 1
        return ret
