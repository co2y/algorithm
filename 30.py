# not good, 枚举可能开始的每个位置。判断当前形成的子串有没有可能是符合要求的。
class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        lens=len(s)
        lenw=len(words[0])
        length=len(words)  
        map={}
        res=[]  
        for i in range(length):  
            if words[i] in map:
                map[words[i]]+=1  
            else:
                map[words[i]]=1  
            if not words[i] in s:
                return res
                
        for i in range(lens-lenw*length+1):  
            tmp={};j=0;flag=True  
            for j in range(length):  
                pos=i+j*lenw  
                sub=s[pos:pos+lenw]  
                if sub in map:  
                    num=0  
                    if sub in tmp:
                        num=tmp[sub]  
                    if map[sub] < num+1:
                        flag=False
                        break  
                    tmp[sub]=num+1  
                else:
                    flag=False
                    break  
            if flag:
                res.append(i)  
        return res  