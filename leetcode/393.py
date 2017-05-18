class Solution(object):
    def validUtf8(self, data):
        """
        :type data: List[int]
        :rtype: bool
        """
        flag = 0
        for each in data:
            if flag > 0:
                if each & 0x80 == 0x80:
                    flag -= 1
                    continue
                else:
                    return False

            if each & 0x80 == 0:
                continue
            if each & 0xE0 == 0xC0:
                flag = 1
                continue
            if each & 0xF0 == 0xE0:
                flag = 2
                continue
            if each & 0xF8 == 0xF0:
                flag = 3
                continue

            return False

        return True if flag == 0 else False
