class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        l = len(A)
        diff = []
        for i in range(1,l):
            diff.append(A[i]-A[i-1])


        count = 1
        ans = 0
        for i in range(1,l-1):

            if diff[i] == diff[i-1]:
                count+=1
            else:
                ans = ans + count*(count-1)//2
                count = 1

        ans = ans + count*(count-1)//2
        return ans
