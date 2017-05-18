class Solution(object):
    def findSubstringInWraproundString(self, p):
        """
        :type p: str
        :rtype: int
        """
        if not p:
            return 0

        l = len(p)
        temp = p[0]
        ss = []
        for i in range(1, l):
            if ord(p[i]) - ord(p[i - 1]) == 1 or p[i] == 'a' and p[i -
                                                                   1] == 'z':
                temp += p[i]
            else:
                ss.append(temp)
                temp = p[i]
        ss.append(temp)
        # s = sorted(set(ss), key=lambda x:len(x), reverse=True)
        # s = sorted(set(ss))
        s = ss
        visit = {}
        ans = 0
        for each in s:
            # if each[0] not in visit:
            le = len(each)
            for i in range(le):
                if each[i] not in visit:
                    ans = ans + le - i
                    visit[each[i]] = le - i
                else:
                    if visit[each[i]] >= le - i:
                        pass
                    else:
                        ans = ans + le - i - visit[each[i]]
                        visit[each[i]] = le - i
            # print ans
            # else:
            #     if visit[each[0]] >= len(each):
            #         continue
            #     else:
            #         hascount = visit[each[0]] * (visit[each[0]] + 1) / 2
            #         ans = ans + len(each)*(len(each)+1)/2 - hascount
            #         print ans
            #         le = len(each)
            #         for i in range(le):
            #             visit[each[i]] = le - i
        return ans
