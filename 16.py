class Solution(object):

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        nums.sort()
        length = len(nums)
        if length < 3:
            return
        closet = nums[0] + nums[1] + nums[2]
        error = abs(closet - target)
        for i in range(length - 2):
            j = i + 1
            k = length - 1
            while j < k:
                if nums[i] + nums[j] + nums[k] == target:
                    return target
                if abs(nums[i] + nums[j] + nums[k] - target) < error:
                    closet = nums[i] + nums[j] + nums[k]
                    error = abs(closet - target)
                if nums[i] + nums[j] + nums[k] < target:
                    j += 1
                if nums[i] + nums[j] + nums[k] > target:
                    k -= 1
        return closet
