class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        r = 1
        base = x
        minus = 0
        if n < 0:
            minus = -1
            n = -n
        while n:
            if n & 1 == 1:
                r = r * base
            base = base * base
            n = n >> 1
        return r if not minus else 1 / r
