class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        from collections import Counter
        m = {}
        for ch in licensePlate.lower():
            if ch.isalpha():
                if ch not in m:
                    m[ch] = 1
                else:
                    m[ch] = m[ch] + 1

        mc = Counter(m)
        ans = ""
        # print(mc)
        for word in words:
            tc = Counter(word)
            # print(tc)
            if not mc - tc:
                if ans == "" or len(word) < len(ans):
                    ans = word
        return ans
        