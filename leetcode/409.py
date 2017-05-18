class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import Counter
        c = Counter(s)
        ans = 0
        find = 0
        for each in c:
            if c[each] & 1 == 0:
                ans += c[each]
            else:
                ans += c[each] - 1
                find = 1
        return ans + 1 if find else ans
