class Solution(object):

    def twoSum(self, nums, target):
        """
        :type sorted_nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        sorted_nums = sorted(nums)
        for num1 in sorted_nums[:-1]:
            for num2 in sorted_nums[sorted_nums.index(num1) + 1:]:
                if num1 + num2 == target:
                    index = [i + 1 for i, x in enumerate(nums) if x == num1]
                    if len(index) > 1:
                        return index
                    else:
                        index.append(
                            [i + 1 for i, x in enumerate(nums)if x == num2][0])
                        return sorted(index)
                elif num1 + num2 > target:
                    break
# 前后夹逼更好
