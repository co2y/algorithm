class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 2:
            return 1
            
        if n == 3:
            return 2
            
        
        a = n // 3
        b = n % 3
        
        if b == 0:
            return 3**a
        
        if b == 1:
            return 3**(a-1)*4
            
        if b == 2:
            return 3**a * 2
            
        
        
        