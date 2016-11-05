class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """

        def dfs(m, n, p):

            c = board[m][n]
            if c == '#' or p.next[ord(c) - ord('a')] == None:
                return
            p = p.next[ord(c) - ord('a')]
            if p.word:
                res.append(p.word)
                p.word = None

            board[m][n] = '#'
            if m > 0:
                dfs(m - 1, n, p)
            if n > 0:
                dfs(m, n - 1, p)
            if m < len(board) - 1:
                dfs(m + 1, n, p)
            if n < len(board[0]) - 1:
                dfs(m, n + 1, p)
            board[m][n] = c

        def build_trie(s):
            root = TrieNode()
            for w in s:
                p = root
                for c in w:
                    index = ord(c) - ord('a')
                    if p.next[index] is None:
                        p.next[index] = TrieNode()
                    p = p.next[index]
                p.word = w
            return root

        class TrieNode:
            def __init__(self):
                self.next = [None] * 26
                self.word = ""

        res = []
        root = build_trie(words)
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(i, j, root)

        return res
