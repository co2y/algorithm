class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        for i in range(l-1,0,-1):
            if nums[i] == nums[i-1]:
                del nums[i]
        
        l = len(nums)
        if l <= 2:
            return l

        for i in range(l-1,2,-1):
        	if (nums[i] - nums[i-1]) * (nums[i-1] - nums[i-2]) >= 0:
        	    del nums[i-1]
                
        if len(nums) >= 3:
            if (nums[0] - nums[1]) * (nums[1] - nums[2]) > 0:
                return len(nums) - 1
        	
        return len(nums)

def wiggleMaxLength(self, nums):
    nan = float('nan')
    diffs = [a-b for a, b in zip([nan] + nums, nums + [nan]) if a-b]
    return sum(not d*e >= 0 for d, e in zip(diffs, diffs[1:]))