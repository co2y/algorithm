class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        
        red = 0
        blue = len(nums) - 1
        i = 0
        
        while i <= blue:
            if nums[i] == 0:
                nums[red], nums[i] = nums[i], nums[red]
                i += 1
                red += 1
            elif nums[i] == 2:
                nums[i], nums[blue] = nums[blue], nums[i]
                blue -= 1
            else:
                i+= 1