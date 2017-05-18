class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        first = 0
        second = 0
        while second < l:
            while first < l and nums[first] != 0:
                first += 1
                
            if first == l:
                return
            
            second = first + 1
            
            while second < l and nums[second] == 0:
                second += 1
                
            if second == l:
                return
            
            nums[first], nums[second] = nums[second], nums[first]