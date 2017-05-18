class Solution(object):

    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        a = int(str(x)[::-1])
        if a > 2147483647:
            return False
        elif a == x:
            return True
        else:
            return False
