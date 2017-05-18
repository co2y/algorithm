class Solution(object):

    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return '1'
        s = '1#'
        count = 1
        while n > 1:
            xx = ''
            n -= 1
            length = len(s)
            for each in range(length - 1):
                if s[each] == s[each + 1]:
                    count += 1
                else:
                    xx = xx + str(count) + s[each]
                    count = 1
            s = xx + '#'
        return s[:-1]
