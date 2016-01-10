class Solution(object):

    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        xx_map = {'M': 1000, 'D': 500, 'C': 100,
                  'L': 50, 'X': 10, 'V': 5, 'I': 1}
        length = len(s)
        ans = 0
        i = 0
        while True:
            if i == length:
                break
            if i == (length - 1):
                ans += xx_map[s[i]]
                break
            if xx_map[s[i]] < xx_map[s[i + 1]]:
                ans += xx_map[s[i + 1]] - xx_map[s[i]]
                i += 2
            else:
                ans += xx_map[s[i]]
                i += 1
        return ans
