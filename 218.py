class Solution:
    def getSkyline(self, buildings):
        n = len(buildings)
        if n == 0:
            return []
        if n == 1:
            # Start and end point of building
            return [[buildings[0][0], buildings[0][2]], [buildings[0][1], 0]]
        mid = (n + 1) / 2
        left = self.getSkyline(buildings[:mid])
        right = self.getSkyline(buildings[mid:])

        # Merging the list of critical points coming from left and from right

        m = len(left)
        n = len(right)
        i = 0
        j = 0
        h1, h2 = -1, -1
        result = []

        while i < m and j < n:
            if left[i][0] < right[j][0]:
                # Left point comes first, update h1
                h1 = left[i][1]
                x = left[i][0]
                i += 1
            elif left[i][0] > right[j][0]:
                # Right point comes first, update h2
                h2 = right[j][1]
                x = right[j][0]
                j += 1
            else:
                # Left and right point have the same x value
                h1 = left[i][1]
                h2 = right[j][1]
                x = right[j][0]
                i += 1
                j += 1

            new = [x, max(h1, h2)]
            if result == [] or result[-1][1] != new[1]:
                result.append(new)

        while i < m:
            if result == [] or result[-1][1] != left[i][1]:
                result.append(left[i][:])
            i += 1
        while j < n:
            if result == [] or result[-1][1] != right[j][1]:
                result.append(right[j][:])
            j += 1
        return result