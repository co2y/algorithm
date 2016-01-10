class Solution(object):

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        b = []
        left = ['(', '[', '{']
        right = [')', ']', '}']
        for temp in s:
            if temp in left:
                b.append(temp)
            elif not b or b.pop() != left[right.index(temp)]:
                return False
        return not b
