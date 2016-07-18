class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        count = 0
        r = []
        
        ind = [0] * numCourses
        outd = [[] for _ in range(numCourses)]
        
        
        for pair in prerequisites:
            ind[pair[0]] += 1
            outd[pair[1]].append(pair[0])
    
        from collections import deque
        dq = deque()
        
        for i in range(numCourses):
            if ind[i] == 0:
                dq.append(i)
                
        while dq:
            now = dq.popleft()
            r.append(now)
            count += 1
            for each in outd[now]:
                ind[each] -= 1
                if ind[each] == 0:
                    dq.append(each)
                    
        return r if count == numCourses else []