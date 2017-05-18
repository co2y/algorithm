class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        
        extra_space_m = [0] * m
        extra_space_n = [0] * n
        
        if not matrix:
            return
        
        
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    extra_space_m[i] = 1
                    extra_space_n[j] = 1
        
        for i,each in enumerate(extra_space_m):
            if each == 1:
                for j in range(n):
                    matrix[i][j] = 0
                    
        for i,each in enumerate(extra_space_n):
            if each == 1:
                for j in range(m):
                    matrix[j][i] = 0
                    
        