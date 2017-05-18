# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator(object):
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """


class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.i = iterator
        self.haspeeked = False
        self.peekednum = None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if not self.haspeeked:
            self.haspeeked = True
            self.peekednum = self.i.next()
            return self.peekednum

        return self.peekednum

    def next(self):
        """
        :rtype: int
        """
        if self.haspeeked:
            self.haspeeked = False
            return self.peekednum

        return self.i.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.haspeeked or self.i.hasNext()


# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
