# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        find = [0]
        def get_ancestor(path, now, target):
            if find[0] != 0:
                return

            if now == target:
                find[0] = path[:]
                return
            else:
                if now.left:
                    path.append(now.left)
                    get_ancestor(path, now.left, target)
                    path.pop()

                if now.right:
                    path.append(now.right)
                    get_ancestor(path, now.right, target)
                    path.pop()

        get_ancestor([root], root, p)
        sp = find[0]

        find[0] = 0

        get_ancestor([root], root, q)
        sq = find[0]



        ret = root
        l = min(len(sp),len(sq))

        for i in range(l):
            if sp[i] != sq[i]:
                ret = sp[i-1]
                break
            else:
                ret = sp[i]

        return ret
