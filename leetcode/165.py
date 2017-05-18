class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        s1 = version1.split('.')
        s2 = version2.split('.')

        from itertools import izip_longest
        for a, b in izip_longest(s1, s2, fillvalue=0):
            if int(a) > int(b):
                return 1
            if int(a) < int(b):
                return -1

        return 0
