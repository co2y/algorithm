# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        stack = [(root.left, root.right)]
        while stack:
          left, right = stack.pop()
          if left is None and right is None:
              continue
          if left is None or right is None:
              return False
          if left.val == right.val:
              stack.append((left.left, right.right))
              stack.append((left.right, right.left))
          else:
              return False
        return True
        
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.flag = True
        
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
          return True
        else:
          return self.isMirror(root.left, root.right)

    def isMirror(self, left, right):
        if not self.flag:
            return False
            
        if left is None and right is None:
            return True
        if left is None or right is None:
            self.flag = False
            return False
        
        if left.val == right.val:
            outPair = self.isMirror(left.left, right.right)
            inPiar = self.isMirror(left.right, right.left)
            return outPair and inPiar
        else:
            self.flag = False
            return False
        