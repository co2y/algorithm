class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        def is_palindrome(sub_s):
            head = 0
            tail = len(sub_s) - 1
            while head != tail:
                if head == tail + 1:
                    break
                if sub_s[head] != sub_s[tail]:
                    return False
                else:
                    head += 1
                    tail -= 1
            return True
            
        ls = len(s)
        lp = 0
        for i in range(ls,1,-1):
            if is_palindrome(s[:i]):
                lp = i
                break
        
        if lp == 0:
            return s[1:][::-1] + s
        else:
            return s[lp:ls][::-1] + s

        
s = Solution()
print s.shortestPalindrome("abbacd")
print s.shortestPalindrome("aacecaaa")
print s.shortestPalindrome("abcd")