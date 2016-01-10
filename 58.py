class Solution(object):

    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        a = s.split(' ')[-1]
        return len(a)
