class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.q = []
        self.index = 0
        

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.q.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        self.index += 1
        

    def peek(self):
        """
        :rtype: int
        """
        return self.q[self.index]
        

    def empty(self):
        """
        :rtype: bool
        """
        return self.index == len(self.q)