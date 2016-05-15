class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        order = preorder.split(',')
        if not order:
            return False
        
        if order[0] == '#':
            if len(order) == 1:
                return True
            else:
                return False
                
        need = 2
        l = len(order)
        index = 1
        while index < l:
            if order[index] != '#':
                need += 1
            else:
                need -= 1
            index += 1
            if need == 0 and index < l:
                return False
            
        if need == 0:
            return True
        else:
            return False
        