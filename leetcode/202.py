class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        def get_next(n):
            r = 0
            while n != 0:
                r = r + (n%10)**2
                n = n // 10
            return r
                
            
        n = abs(n)
        pre = {n}
        while n != 1:
            n = get_next(n)
            if n in pre:
                return False
            pre.add(n)
            
        return True    
        
s = Solution()
print s.isHappy(2)