class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        stack = []
        ans = 0
        now = 0
        if s[0] == '(':
            stack.append(0);
        for i in range(1,len(s)):
            if s[i] == '(':
                stack.append(now)
                now = 0
            else:
                if not stack:
                    now = 0
                else:
                    now = now + stack.pop() + 2
                
                ans = max(ans, now)
                
        return ans