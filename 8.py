class Solution(object):

    def myAtoi(self, strx):
        """
        :type strx: str
        :rtype: int
        """
        strx = strx.strip()
        try:
            strx = re.match(r'^[+-]?\d+', strx).group()
            rint = int(strx)
            if rint > 2147483647:
                return 2147483647
            elif rint < -2147483648:
                return -2147483648
            else:
                return rint
        except:
            return 0
