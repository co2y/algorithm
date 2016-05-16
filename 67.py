class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        la = len(a)
        lb = len(b)
        
        l = max(la,lb)
        if l == lb:
            a = '0' * (lb-la) + a
        else:
            b = '0' * (la-lb) + b
        
        
        ans = ""
        flag = 0
        
        for i in range(l):
            temp = int(a[l-i-1]) + int(b[l-i-1]) + flag 
            if temp > 1:
                ans = str(temp-2) + ans 
                flag = 1
            else:
                ans = str(temp) + ans
                flag = 0
                
        if flag == 1:
            ans = "1" + ans
        
        return ans