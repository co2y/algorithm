class Solution(object):

    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        r_list = []
        nums.sort()
        length = len(nums)
        if length < 4:
            return []
        for i in range(length - 3):
            for j in range(i + 1, length - 2):
                k = j + 1
                l = length - 1
                while k < l:
                    if nums[i] + nums[j] + nums[k] + nums[l] == target:
                        r_list.append([nums[i], nums[j], nums[k], nums[l]])
                        break

                    if nums[i] + nums[j] + nums[k] + nums[l] < target:
                        k += 1

                    if nums[i] + nums[j] + nums[k] + nums[l] > target:
                        l -= 1

                    while k < length - 1 and nums[k] == nums[k + 1]:
                        k += 1
                    while l > 0 and nums[l] == nums[l - 1]:
                        l -= 1
        return r_list
