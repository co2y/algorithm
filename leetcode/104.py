# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.maxl = 0
        
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        def dfs(node, level):
        
            if node is None:
                if level > self.maxl:
                    self.maxl = level
            else:
                dfs(node.left, level+1)
                dfs(node.right, level+1)
                
        
        dfs(root, 0)
        return self.maxl