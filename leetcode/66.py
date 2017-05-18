class Solution(object):

    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        return [int(each) for each in str(int(''.join(str(xx) for xx in digits)) + 1)]
