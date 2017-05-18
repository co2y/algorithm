class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(findNums)
        ans = [-1] * n
        stack = []
        hashmap = {}
        for num in nums:
            while stack and stack[-1] < num:
                hashmap[stack.pop()] = num
            stack.append(num)

        for i, num in enumerate(findNums):
            ans[i] = hashmap.get(num, -1)
        return ans
