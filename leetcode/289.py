class Solution(object):
    def gameOfLife(self, board):
        m = len(board)
        if m == 0:
            return

        n = len(board[0])
        if n == 0:
            return

        directionX = [-1, -1, -1,  0, 0,  1, 1, 1]
        directionY = [-1,  0,  1, -1, 1, -1, 0, 1]

        for x in range(m):
            for y in range(n):
                liveNeighbors = getLiveNeighbors(x, y, m, n, board, directionX, directionY)

                if board[x][y] & 1 == 1:
                    if liveNeighbors < 2:
                        board[x][y] = 1
                    elif liveNeighbors == 2 or liveNeighbors == 3:
                        board[x][y] = 3
                    else:
                        board[x][y] = 1
                else:
                    if liveNeighbors == 3:
                        board[x][y] = 2

        for x in range(m):
            for y in range(n):
                board[x][y] = board[x][y] >> 1

    
def getLiveNeighbors(x, y, m, n, board, directionX, directionY):
    count = 0

    for i in range(8):
        newX = x + directionX[i]
        newY = y + directionY[i]

        if newX >= 0 and newX < m and newY >= 0 and newY < n and board[newX][newY] & 1 == 1:
            count += 1
    return count