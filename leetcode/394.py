class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = list(s)
        
        from collections import defaultdict 
        temp = defaultdict(str)
        right = 0
        
        while s:
            c = s.pop()

            if 'a'<= c <= 'z':
                temp[right] = c + temp[right]
            elif c == ']':
                right += 1
            elif c == '[':
                times = ""
                while s and '0'<=s[-1]<='9':
                    times = s.pop() + times
                temp[right] =  int(times) * temp[right]
                temp[right-1] = temp[right] + temp[right-1]
                temp[right] = ""
                right -= 1
                
        return temp[0]
                
        