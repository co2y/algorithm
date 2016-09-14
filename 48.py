class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        m = matrix
        
        l = len(m)-1
        for i in range((l+1)//2 ):
            for j in range(l//2 +1):
                temp = m[i][j]
                m[i][j] = m[l-j][i]
                m[l-j][i] = m[l-i][l-j]
                m[l-i][l-j] = m[j][l-i]
                m[j][l-i] = temp