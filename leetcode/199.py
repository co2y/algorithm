# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        from collections import deque
        dq = deque()
        dq.append(root)
        dq.append("#")
        
        if not root:
            return []
        
        pre = 0
        ans = []
        while dq:
            now = dq.popleft()
            if now == "#":
                if dq:
                    dq.append("#")
                    ans.append(pre)
                else:
                    ans.append(pre)
            elif now:
                if now.left:
                    dq.append(now.left)
                if now.right:
                    dq.append(now.right)
                pre = now.val
                
        return ans
            
        