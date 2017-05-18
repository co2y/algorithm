class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        one = 0 
        two = 0
        for num in nums:
            one = one ^ num & ~two
            two = two ^ num & ~one
        return one