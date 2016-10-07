class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        from collections import deque
        dq = deque()
        ans = []
        for i,n in enumerate(nums):
        	while dq and nums[dq[-1]]<n:
        		dq.pop()
        	dq.append(i)
        	if dq[0] == i-k:
        		dq.popleft()
        	if i >= k-1:
        		ans.append(nums[dq[0]])
        return ans