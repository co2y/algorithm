import re


class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        ans = []
        for word in words:
            if self.check(word):
                ans.append(word)
        return ans

    def check(self, word):
        return re.compile('^([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$',
                          re.I).match(word)
