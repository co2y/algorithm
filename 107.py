# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        nodelist = [[root]]
        
        while nodelist[-1]:
            temp = []
            for eachnode in nodelist[-1]:
                if eachnode.left is not None:
                    temp.append(eachnode.left)
                if eachnode.right is not None:
                    temp.append(eachnode.right)
            nodelist.append(temp)
            
        length = len(nodelist)
        rlist = []
        
        for i in range(length-2,-1,-1):
            temp = []
            for j in nodelist[i]:
                temp.append(j.val)
            rlist.append(temp)
            
        return rlist
        