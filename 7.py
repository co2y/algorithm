class Solution(object):

    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        rstr = str(x)
        if rstr.startswith('-'):
            rstr = rstr[1:]
            return -int(rstr[::-1])
        else:
            return int(rstr[::-1])
