class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        count = 0
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
            count+=1
            for each in outd[now]:
                ind[each] -= 1
                if ind[each] == 0:
                    dq.append(each)
                    
        return count == numCourses