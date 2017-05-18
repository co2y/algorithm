class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        # i,j,k = 0,0,0
        # s = []
        # s1 += '!'
        # s2 += '@'
        # while k<len(s3):
            
        #     if s3[k] == s1[i] and s3[k] != s2[j]:
        #         k += 1
        #         i += 1
        #     elif s3[k] != s1[i] and s3[k] == s2[j]:
        #         k += 1
        #         j += 1
        #     elif s3[k] == s1[i] and s3[k] == s2[j]:
        #         s.append((i, j+1, k+1, ))
        #         i += 1
        #         k += 1
        #     else:
        #         if s:
        #             i,j,k = s.pop()
        #         else:
        #             break
        
        # if k == len(s3) and i == len(s1)-1 and j == len(s2)-1:
        #     return True
        # else:
        #     return False
        m = len(s1)
        n = len(s2)
        if m+n != len(s3):
            return False
            
        match = [[False for i in range(n+1)] for j in range(m+1)]
        
        match[0][0] = True
        
        for i in range(1,n+1):
            if s2[i-1] == s3[i-1]:
                match[0][i] = True
            else:
                break
                
        for j in range(1,m+1):
            if s1[j-1] == s3[j-1]:
                match[j][0] = True
            else:
                break
                
        for i in range(1,m+1):
            for j in range(1,n+1):
                match[i][j] = True if (match[i-1][j] and s1[i-1]==s3[i+j-1] or match[i][j-1] and s2[j-1]==s3[i+j-1]) else False
                
                
        return match[m][n]
        