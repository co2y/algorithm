class Solution(object):
    def findAllConcatenatedWordsInADict(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        words_set = set(words)
        ans = []

        def check(w):
            if w != word and w in words_set:
                return True

            for i in range(len(w)):
                if w[:i + 1] in words_set and check(w[i + 1:]):
                    return True

            return False

        for word in words:
            if check(word):
                ans.append(word)

        return ans
