# 本题很没有意思，需要先用139题来判断整个s是否可分，dp复杂度是n^2。如果可分再进行分解，复杂度n^3。不然会一直TLE。
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        length = len(s)
        tmp = []
        ans = []
        start_index = 0
        stop_index = 1
        
        dp = [False] * (length + 1)
        if s is None:
            flag = True
        else:
            dp[0] = True
    
            for i in range(length):
                for j in range(i,-1,-1):
                    if dp[j] and s[j:i+1] in wordDict:
                        dp[i+1] = True
    
            flag = dp[len(s)]
        
        if not flag:
            return []
            
        while 1:
            word = s[start_index:stop_index]
            if word in wordDict:
                tmp.append(word)
                if stop_index == length:
                    ans.append(" ".join(tmp))
                    w1 = tmp.pop()
                    if tmp:
                        w2 = tmp.pop()
                        stop_index = start_index + 1
                        start_index = start_index - len(w2)
                        
                    else:
                        break
                else:
                    start_index = stop_index
                    stop_index = stop_index + 1
            else:
                if stop_index == length:
                    if tmp:
                        w = tmp.pop()
                        stop_index = start_index + 1
                        start_index = start_index - len(w)
                    else:
                        break
                else:
                    stop_index = stop_index + 1
        return ans

#TLE
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        length = len(s)
        tmp = []
        ans = []
        start_index = 0
        stop_index = 1
        
         
        while 1:
            word = s[start_index:stop_index]
            if word in wordDict:
                tmp.append(word)
                if stop_index == length:
                    ans.append(" ".join(tmp))
                    w1 = tmp.pop()
                    if tmp:
                        w2 = tmp.pop()
                        stop_index = start_index + 1
                        start_index = start_index - len(w2)
                        
                    else:
                        break
                else:
                    start_index = stop_index
                    stop_index = stop_index + 1
            else:
                if stop_index == length:
                    if tmp:
                        w = tmp.pop()
                        stop_index = start_index + 1
                        start_index = start_index - len(w)
                    else:
                        break
                else:
                    stop_index = stop_index + 1
        return ans
        
        
# maximum recursion depth exceeded
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        length = len(s)
        ans = []
        def bt(start_index, stop_index, tmp):
            if stop_index > len(s):
                return 
            
            word = s[start_index:stop_index]
            if word in wordDict:
                tmp.append(word)
                if stop_index == length:
                    ans.append(" ".join(tmp))
                    w1 = tmp.pop()
                    if tmp:
                        w2 = tmp.pop()
                        bt(start_index-len(w2), start_index+1, tmp)
                    else:
                        return
                else:
                    bt(stop_index, stop_index+1, tmp)
            else:
                if stop_index == length:
                    if tmp:
                        w = tmp.pop()
                        bt(start_index-len(w), start_index+1, tmp)
                    else:
                        return
                else:
                    bt(start_index, stop_index+1, tmp)

        bt(0, 1, [])
        return ans
        
if __name__ == '__main__':
    sol = Solution()
    str1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    wordd = ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    print sol.wordBreak(str1, set(wordd))