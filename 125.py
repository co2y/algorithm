class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s:
            return True
        
        left = 0
        right = len(s) - 1
        
        s = s.lower()
        
        def isalphanumber(char):
            if (char >= 'a' and char <= 'z') or (char >= '0' and char <= '9'):
                return True
            else:
                return False
        
        while left < right:
            while left < len(s) and not isalphanumber(s[left]):
                left += 1
            
            while right > 0 and not isalphanumber(s[right]):
                right -= 1
            
            if left > right:
                return True
                
            if s[left] != s[right]:
                return False
            else:
                left += 1
                right -= 1
                
        return True
    
solution = Solution()
solution.isPalindrome("race a car")