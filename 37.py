class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.board = board
        self.solve()
    
    def findUnassigned(self):
        for row in range(9):
            for col in range(9):
                if self.board[row][col] == ".":
                    return row, col
        return -1, -1
    
    def solve(self):
        row, col = self.findUnassigned()
        #no unassigned position is found, puzzle solved
        if row == -1 and col == -1:
            return True
        for num in ["1","2","3","4","5","6","7","8","9"]:
            if self.isSafe(row, col, num):
                self.board[row][col] = num
                if self.solve():
                    return True
                self.board[row][col] = "."
        return False
            
    def isSafe(self, row, col, num):
        boxrow = row - row % 3
        boxcol = col - col % 3
        if self.checkrow(row,num) and self.checkcol(col,num) and self.checksquare(boxrow, boxcol, num):
            return True
        return False
    
    def checkrow(self, row, num):
        for col in range(9):
            if self.board[row][col] == num:
                return False
        return True
    
    def checkcol(self, col, num):
        for row in range(9):
            if self.board[row][col] == num:
                return False
        return True
       
    def checksquare(self, row, col, num):
        for r in range(row, row + 3):
            for c in range(col, col + 3):
                if self.board[r][c] == num:
                    return False
        return True