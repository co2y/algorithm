class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if not matrix:
            return
        
        m = len(matrix)
        n = len(matrix[0])
    
        self.suma = [[0] * n for i in range(m)]
        self.suma[0][0] = matrix[0][0]
        
        for i in range(1,m):
            self.suma[i][0] = matrix[i][0] + self.suma[i-1][0]
            
        for j in range(1,n):
            self.suma[0][j] = matrix[0][j] + self.suma[0][j-1]
        
        for i in range(1,m):
            for j in range(1,n):
                self.suma[i][j] = self.suma[i-1][j] + self.suma[i][j-1] - self.suma[i-1][j-1] + matrix[i][j]
        

    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        # print self.suma[row2][col2]
        # print self.suma[row2][col1-1] if col1>0 else 0
        # print self.suma[row1-1][col2] if row1> 0 else 0
        # print self.suma[row1-1][col1-1] if row1>0 and col1>0 else 0
        return (self.suma[row2][col2]) - (self.suma[row2][col1-1] if col1>0 else 0) - (self.suma[row1-1][col2] if row1> 0 else 0) + (self.suma[row1-1][col1-1] if row1>0 and col1>0 else 0)


# Your NumMatrix object will be instantiated and called as such:
# numMatrix = NumMatrix(matrix)
# numMatrix.sumRegion(0, 1, 2, 3)
# numMatrix.sumRegion(1, 2, 3, 4)
# [[3,0,1,4,2],
#  [5,6,3,2,1],
#  [1,2,0,1,5],
#  [4,1,0,1,7],
#  [1,0,3,0,5]],
# sumRegion(2,1,4,3),sumRegion(1,1,2,2),sumRegion(1,2,2,4)