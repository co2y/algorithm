class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        if x+y < z:
            return False
            
        if x==0 or y==0:
            return x+y==z or x==z or y==z
            
        def gcd(x, y):
            while y!=0:
                temp = y
                y = x%y
                x = temp
            return x
            
        if z%gcd(x,y)==0:
            return True
        else:
            return False