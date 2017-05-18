class Solution(object):
    def isUgly(self, num):
        if num <= 0:
            return False
        if num == 1:
            return True
        while 1:
            if num % 2 == 0:
                num = num / 2
            elif num % 3 == 0:
                num = num / 3
            elif num % 5 == 0:
                num = num / 5
            else:
                break
        if num == 1:
            return True
        else:
            return False
