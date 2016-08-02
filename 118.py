class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        for i in range(numRows):
            temp = [0] * (i+1)
            temp[0], temp[-1] = 1, 1
            for j in range(1, i):
                temp[j] = ans[i-1][j-1] + ans[i-1][j]
            ans.append(temp)
            
        return ans
                