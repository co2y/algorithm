#
# @lc app=leetcode id=507 lang=python3
#
# [507] Perfect Number
#
# https://leetcode.com/problems/perfect-number/description/
#
# algorithms
# Easy (33.98%)
# Total Accepted:    38.4K
# Total Submissions: 112.9K
# Testcase Example:  '28'
#
# We define the Perfect Number is a positive integer that is equal to the sum
# of all its positive divisors except itself. 
# 
# Now, given an integer n, write a function that returns true when it is a
# perfect number and false when it is not.
# 
# 
# Example:
# 
# Input: 28
# Output: True
# Explanation: 28 = 1 + 2 + 4 + 7 + 14
# 
# 
# 
# Note:
# The input number n will not exceed 100,000,000. (1e8)
# 
#
class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        def getDivisors(n):
            divisors = []
            divisors.append(1)
            for i in range(2, n):
                if i * i > n:
                    break
                if n % i == 0:
                    divisors.append(i)
                    if i * i != n:
                        divisors.append(n / i)
            return divisors
        if num <= 1:
            return False
        return sum(getDivisors(num)) == num

