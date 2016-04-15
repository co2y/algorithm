class TrieNode(object):
    def __init__(self):
        self.children = dict()
        self.isword = False


class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.root = TrieNode()
        self.isfind = False

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        temp_root = self.root
        for eachchar in word:
            if eachchar in temp_root.children:
                temp_root = temp_root.children[eachchar]
            else:
                temp_root.children[eachchar] = TrieNode()
                temp_root = temp_root.children[eachchar]
        temp_root.isword = True
        

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        if not word:
            return True
        else:
            self.isfind = False
            self.dfs(word, 0, self.root)
            return self.isfind
            
    def dfs(self, word, length, node):
        if self.isfind:
            return True
            
        if length == len(word):
            self.isfind = node.isword
        
        elif word[length] in node.children:
            self.dfs(word, length+1, node.children[word[length]])
        elif word[length] == '.':
            for eachchild in node.children:
                self.dfs(word, length+1, node.children[eachchild])
            
        

# Your WordDictionary object will be instantiated and called as such:
# wordDictionary = WordDictionary()
# wordDictionary.addWord("word")
# wordDictionary.search("pattern")