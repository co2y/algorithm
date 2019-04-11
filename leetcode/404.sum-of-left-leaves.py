#
# @lc app=leetcode id=404 lang=python3
#
# [404] Sum of Left Leaves
#
# https://leetcode.com/problems/sum-of-left-leaves/description/
#
# algorithms
# Easy (48.86%)
# Total Accepted:    120.8K
# Total Submissions: 247.3K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# Find the sum of all left leaves in a given binary tree.
# 
# Example:
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
# 
# There are two left leaves in the binary tree, with values 9 and 15
# respectively. Return 24.
# 
# 
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        def helper(node, is_left):
            if node.left is None and node.right is None and is_left:
                return node.val
            sum = 0
            if node.left is not None:
                sum += helper(node.left, True)
            if node.right is not None:
                sum += helper(node.right, False)
            return sum

        if root is None:
            return 0
        else:
            return helper(root, False)
    

