class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == '0' or num2 == '0':
            return '0'
        
        l1 = len(num1)
        l2 = len(num2)
        
        ans = [0] * (l1+l2)
        
        for i in range(l1-1, -1, -1):
            for j in range(l2-1, -1, -1):
                ans[(l1-1-i)+(l2-1-j)] += int(num1[i]) * int(num2[j])
        #print ans
        for i in range(l1+l2):
            if ans[i] >= 10:
                ans[i+1] = ans[i+1] + (ans[i] // 10)
                ans[i] = ans[i] % 10
                
        return ''.join([str(each) for each in ans[::-1]]).lstrip('0')