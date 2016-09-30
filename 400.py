class Solution(object):
    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        start, size, step = 1, 1, 9
        
        while n > size*step:
            n = n - (size*step)
            size = size + 1
            step = step * 10
            start = start * 10
            
        return int(str(start + (n-1)//size)[(n-1)%size])