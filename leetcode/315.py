class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l = len(nums)
        sortedarr = [0] * l
        ans = [0] * l

        enum = list(enumerate(nums))

        def merge_sort(start, end):
            if start >= end:
                return

            mid = start + (end - start) / 2
            merge_sort(start, mid)
            merge_sort(mid + 1, end)

            first = mid
            second = end
            temp = end

            while first >= start and second > mid:
                if enum[first][1] > enum[second][1]:
                    ans[enum[first][0]] = ans[enum[first][0]] + second - mid
                    sortedarr[temp] = enum[first]
                    temp -= 1
                    first -= 1
                else:
                    sortedarr[temp] = enum[second]
                    temp -= 1
                    second -= 1

            while first >= start:
                sortedarr[temp] = enum[first]
                temp -= 1
                first -= 1

            while second > mid:
                sortedarr[temp] = enum[second]
                temp -= 1
                second -= 1

            for i in range(start, end + 1):
                enum[i] = sortedarr[i]

        merge_sort(0, l - 1)

        return ans
