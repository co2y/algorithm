class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.children = {}
        self.isword = False

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        now = self.root
        for ch in word:
            if not ch in now.children:
                now.children[ch] = TrieNode()
            now = now.children[ch]
        now.isword = True


    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        now = self.root
        for ch in word:
            if ch in now.children:
                now = now.children[ch]
            else:
                return False
        return now.isword


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        now = self.root
        for ch in prefix:
            if ch in now.children:
                now = now.children[ch]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# trie.search("key")
