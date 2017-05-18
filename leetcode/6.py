class Solution(object):

    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        length = len(s)
        line = [[] for i in range(numRows)]
        rstr = ''
        flag = 1
        index = 0
        if numRows == 1:
            return s
        for char in s:
            if flag == 1:
                line[index].append(char)
                index += 1
            else:
                line[index].append(char)
                index -= 1
            if index == numRows:
                flag = -1
                index -= 2
            if index == -1:
                flag = 1
                index += 2
        for each in line:
            rstr += ''.join(each)
        return rstr
