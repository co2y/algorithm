class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        width = len(matrix)
        length = len(matrix[0])
        
        left = 0
        right = width - 1
        while left < right:
            
            mid = (left + right + 1) / 2
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] < target:
                left = mid
            else:
                right = mid - 1
            
        row = left
        left = 0
        right = length - 1
        while left <= right:
            mid = (left + right) / 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False