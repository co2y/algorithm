class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        n = len(num)
        for i in range(1, n / 2 + 1):
            for j in range(i + 1, 2 * n / 3 + 1):
                if num[0:i].startswith('0'):
                    if i == 1:
                        first = 0
                    else:
                        continue
                else:
                    first = int(num[0:i])

                if num[i:j].startswith('0'):
                    if j - i == 1:
                        second = 0
                    else:
                        continue
                else:
                    second = int(num[i:j])

                temp = ""
                while True:
                    third = first + second
                    temp = temp + str(third)
                    first = second
                    second = third
                    if len(temp) > n - j:
                        break
                if temp.startswith(num[j:]):
                    return True

        return False
