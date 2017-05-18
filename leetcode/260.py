class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = reduce(lambda x,y:x^y,nums)
        
        mask = ans&(-ans)
        
        r = [0, 0]
        
        for num in nums:
            if num&mask == 0:
                r[0] = r[0]^num
            else:
                r[1] = r[1]^num
                
        return r