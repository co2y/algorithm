class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        def dfs(res, cur, num, strtemp, curstr):
            if num==''and res+cur==target:
                pattern.append(strtemp+curstr)
                return 

            for i in range(1, len(num)+1):
                curr=int(num[:i])
                dfs(res+cur, curr, num[i:], strtemp+curstr, '+'+num[:i])
                dfs(res+cur, -1*curr,num[i:], strtemp+curstr, '-'+num[:i])
                dfs(res, cur*curr, num[i:], strtemp, curstr+'*'+num[:i])
                if num[0]=='0':
                    break 

        pattern=[]
        for i in range(1, len(num)+1):
            dfs(0, int(num[:i]), num[i:], '', num[:i] )
            if num[0]=='0':break
        return pattern