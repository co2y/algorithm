class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        nums = map(str, range(1, n + 1))
        nums.sort()
        return map(int, nums)
