class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        ans = [-1] * n
        stack = []
        for i in range(n * 2):
            num = nums[i % n]
            while stack and nums[stack[-1]] < num:
                index = stack.pop()
                ans[index] = num
            if i < n:
                stack.append(i)
        return ans
