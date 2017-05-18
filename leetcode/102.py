# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
            
        ans = dict()
        q = []
        root.level = 0
        q.append(root)
        while q:
            now = q.pop(0)
            if now.left:
                now.left.level = now.level + 1
                q.append(now.left)
            if now.right:
                now.right.level = now.level + 1
                q.append(now.right)
            
            ans[now.level] = ans.get(now.level,[]) + [now.val]
            
        return ans.values()