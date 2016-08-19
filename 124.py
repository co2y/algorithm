# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        ans = [float('-inf')]
        def maxPathDown(node):
            if node is None: return 0
            left = max(0, maxPathDown(node.left))
            right = max(0, maxPathDown(node.right))
            ans[0] = max(ans[0], left + right + node.val)
            
            # key!
            return max(left, right) + node.val
            
        maxPathDown(root)
        return ans[0]