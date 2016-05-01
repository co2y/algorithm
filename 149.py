# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution(object):
    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def maxPoints(self, points):
        if not points:
            return 0

        points = map(lambda p: (p.x, p.y), points)

        counter, points, lines = (
            collections.Counter(points), list(set(points)),
            collections.defaultdict(set))

        for i in xrange(len(points)):
            for j in xrange(i + 1, len(points)):
                (x1, y1), (x2, y2) = points[i], points[j]

                a, b, c = x1 - x2, y2 - y1, x2 * y1 - x1 * y2
                if a < 0 or a == 0 and b < 0:
                    a, b, c = -a, -b, -c

                gcd = self.gcd(self.gcd(abs(a), abs(b)), abs(c))
                lines[(a / gcd, b / gcd, c / gcd)] |= {points[i], points[j]}

        return max([
            sum([counter[p] for p in ps])
            for ps in lines.values()
        ] + counter.values())