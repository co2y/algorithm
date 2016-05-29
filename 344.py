class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        return s[::-1]

java use StringBuilder not String
python str 不能直接赋值，例如s[1] = '5'

class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        ss = list(s)
        left = 0
        right = len(s) - 1
        while left < right:
            ss[left],ss[right] = ss[right],ss[left]
            left += 1
            right -= 1
        return "".join(ss)
        