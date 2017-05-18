class Solution(object):

    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if divisor == 0:
            return 0x7FFFFFFF
        if dividend == 0:
            return 0
        negative = (dividend > 0) ^ (divisor > 0)
        dividend, divisor = abs(dividend), abs(divisor)
        ans = 0
        while dividend >= divisor:
            x = divisor
            i = 1
            while dividend >= x + x:
                x += x
                i += i
            dividend -= x
            ans += i
        ans = 0x7FFFFFFF if not negative and ans > 0x7FFFFFFF else ans
        return -ans if negative else ans
