#
# @lc app=leetcode id=437 lang=python3
#
# [437] Path Sum III
#
# https://leetcode.com/problems/path-sum-iii/description/
#
# algorithms
# Easy (42.33%)
# Total Accepted:    99.2K
# Total Submissions: 234.2K
# Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
#
# You are given a binary tree in which each node contains an integer value.
# 
# Find the number of paths that sum to a given value.
# 
# The path does not need to start or end at the root or a leaf, but it must go
# downwards
# (traveling only from parent nodes to child nodes).
# 
# The tree has no more than 1,000 nodes and the values are in the range
# -1,000,000 to 1,000,000.
# 
# Example:
# 
# root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
# 
# ⁠     10
# ⁠    /  \
# ⁠   5   -3
# ⁠  / \    \
# ⁠ 3   2   11
# ⁠/ \   \
# 3  -2   1
# 
# Return 3. The paths that sum to 8 are:
# 
# 1.  5 -> 3
# 2.  5 -> 2 -> 1
# 3. -3 -> 11
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
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(node, current_sum, ans, vis):
            if node.val + current_sum == sum:
                ans[0] = 1 + ans[0]
            if node.left:
                dfs(node.left, current_sum + node.val, ans, vis)
                if vis.get(node.left) is None: 
                    vis[node.left] = True
                    dfs(node.left, 0, ans, vis)
            if node.right:
                dfs(node.right, current_sum + node.val, ans, vis)
                if vis.get(node.right) is None: 
                    vis[node.right] = True
                    dfs(node.right, 0, ans, vis)
        
        if root is None:
            return 0
        
        vis = {}
        ans = [0]
        dfs(root, 0, ans, vis)
        return ans[0]


