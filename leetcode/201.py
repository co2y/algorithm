class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        num = 0
        
        while m!=n:
            m = m >> 1
            n = n >> 1
            num += 1
            
        return m << num