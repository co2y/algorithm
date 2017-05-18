class Solution(object):

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1 = len(nums1)
        len2 = len(nums2)
        if (len1 + len2) % 2 == 1:
            return self.findkth(nums1, nums2, (len1 + len2) // 2 + 1)
        else:
            return (self.findkth(nums1, nums2, (len1 + len2) / 2) + self.findkth(nums1, nums2, (len1 + len2) / 2 + 1)) / 2.0

    def findkth(self, A, B, k):
        if len(A) < len(B):
            A, B = B, A
        if len(B) == 0:
            return A[k - 1]
        if k == 1:
            return min(A[0], B[0])
        pb = min(k / 2, len(B))
        pa = k - pb
        if A[pa - 1] > B[pb - 1]:
            return self.findkth(A, B[pb:], k - pb)
        elif A[pa - 1] < B[pb - 1]:
            return self.findkth(A[pa:], B, k - pa)
        else:
            return A[pa - 1]
