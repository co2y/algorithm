class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        # 1
        return map(list, sorted(itertools.product(nums1, nums2), key=sum)[:k])

        # 2
        return map(list, heapq.nsmallest(k, itertools.product(nums1, nums2), key=sum))
        return heapq.nsmallest(k, ([u, v] for u in nums1 for v in nums2), key=sum)

        # 3
        streams = map(lambda u: ([u+v, u, v] for v in nums2), nums1)
    	stream = heapq.merge(*streams)
    	return [suv[1:] for suv in itertools.islice(stream, k)]

    	# 4
	    queue = []
	    def push(i, j):
	        if i < len(nums1) and j < len(nums2):
	            heapq.heappush(queue, [nums1[i] + nums2[j], i, j])
	    push(0, 0)
	    pairs = []
	    while queue and len(pairs) < k:
	        _, i, j = heapq.heappop(queue)
	        pairs.append([nums1[i], nums2[j]])
	        push(i, j + 1)
	        if j == 0:
	            push(i + 1, 0)
	    return pairs