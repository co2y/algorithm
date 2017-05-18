class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)

        if l <= 1:
        	return 0

        start = 1
        end = min(l-1, nums[0])

        step = 1
        while end < l-1:
        	maxdest = 0
        	for i in range(start, end+1):
        		maxdest = max(maxdest, nums[i]+i)
        	step += 1
        	start = end + 1
        	end = min(maxdest, l-1)
        	#print start,end

        return step