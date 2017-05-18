class Solution(object):
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if not points:
            return 0
        # 默认的就是先根据第一个排序，再根据第二个数排序
        points.sort()
        ans = 0
        # 记录之前的数
        prev = points[0]
        # 记录之前的数的最右端的最小值
        m = points[0][1]
        for point in points[1:]:
            # 头超过之前的尾巴，或者头超过之前最右端的最小值，此时前面所有的气球需要一刀
            if point[0] > prev[1] or point[0] > m:
                ans += 1
                prev = point
                m = point[1]
            # 根据最右端的最小值
            elif point[1] < m:
                m = point[1]

        return ans + 1
