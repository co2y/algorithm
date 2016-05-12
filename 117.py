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
        def get_next_node(cur):
            while cur:
                if cur.left:
                    return cur, cur.left
                if cur.right:
                    return cur, cur.right
                cur = cur.next
            return None, None

        cur = root
        prev = cur
        while cur:
            # First get the next child (neighbor node in same level)
            next_node, its_child = get_next_node(cur.next)
            if cur.left:
                cur.left.next = cur.right if cur.right else its_child
            if cur.right:
                cur.right.next = its_child
            # If exists a node in my level with at least one child, then
            # go there
            if next_node:
                cur = next_node
            else:
                # Get next node in next level
                cur = prev.left if prev.left else prev.right
                cur, _ = get_next_node(cur)
                prev = cur