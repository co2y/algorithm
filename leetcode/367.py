class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        def getsqrt(n):
            ret = 1.0
            while 1:
                mid = (ret + n/ret) / 2
                if int(mid) == int(ret):
                    break
                else:
                    ret = mid
            return int(ret)

        a = getsqrt(num)

        if a*a == num or (a+1)*(a+1)==num:
            return True
        else:
            return False

## another solution binary search
