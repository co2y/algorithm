class Solution(object):
    def findRepeatedDnaSequences(self, s):
        ans = set()
        exist = set()

        for i in range(len(s)-9):
            if s[i:i+10] in exist:
                ans.add(s[i:i+10])
            else:
                exist.add(s[i:i+10])

        return list(ans)
