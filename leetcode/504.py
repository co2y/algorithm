class Solution(object):
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return '0'

        minus = False
        if num < 0:
            minus = True
            num = -num

        ans = []
        while num != 0:
            ans.append(str(num % 7))
            num = num / 7

        a = "".join(ans[::-1])
        return a if not minus else '-' + a
