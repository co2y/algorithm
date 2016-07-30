class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        length = 2
        front, back = set([beginWord]), set([endWord])
        
        if beginWord not in wordList:
            wordList.add(beginWord)
        if endWord not in wordList:
            wordList.add(endWord)
            
        wordList.discard(beginWord)
        
        while front:
            # generate all valid transformations
            front = wordList & (set(word[:index] + ch + word[index+1:] for word in front 
                                for index in range(len(beginWord)) for ch in 'abcdefghijklmnopqrstuvwxyz'))
            if front & back:
                # there are common elements in front and back, done
                return length
            length += 1
            if len(front) > len(back):
                # swap front and back for better performance (fewer choices in generating nextSet)
                front, back = back, front
            # remove transformations from wordList to avoid cycle
            wordList -= front
        return 0