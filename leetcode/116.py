# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if root is None:
            return
        
        nodelist = [root]
        
        while nodelist:
            now = nodelist.pop(0)
            
            if now.left is not None:
                nodelist.append(now.left)
                now.left.next = now.right
                
            
                nodelist.append(now.right)
                if now.next is not None:
                    now.right.next = now.next.left
                else:
                    now.right.next = None
            
            
            

# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        pre = root
        
        if root is None:
            return
        
        while root.left is not None:
            
            root.left.next = root.right
                
            if root.next is None:
                root = pre.left
                pre = root
            else:
                root.right.next = root.next.left
                root = root.next
            