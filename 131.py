class Solution(object):
#DFS
def partition1(self, s):
    """
    :type s: str
    :rtype: List[List[str]]
    """
    res = []
    def isPal(s):return s ==s[::-1]
    def dfs(s, path):
        if not s:
            res.append(path)
        for i in range (1, len(s)+1):
            if isPal(s[:i]):
                dfs(s[i:], path+[s[:i]])
    dfs(s,[])
    return res
#DP
def partition(self, s):
    def isPal(s):
        return s==s[::-1]
    n = len(s)+1   
    dp = [[[]]]+ [[] for _ in range (n-1)]
    for i in range (1, n):
        for j in range (0, i):
            if isPal(s[j:i]):
                dp[i]+=[each+[s[j:i]] for each in dp[j]]
    return dp[-1]
    
    
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        
        def isPalindrome(subs):
            left = 0
            right = len(subs)-1
            
            while left < right:
                if subs[left] != subs[right]:
                    return False
                else:
                    left += 1
                    right -= 1
            return True
            
        
        def dfs(s, path):
            if not s:
                res.append(path)
            for i in range(1,len(s)+1):
                if isPalindrome(s[:i]):
                    dfs(s[i:], path+[s[:i]])
        
        if not s:
            return []
        res = []   
        dfs(s,[])
        return res
                    