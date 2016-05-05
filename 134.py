class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        cumsum, minimum, min_idx = 0, 0, 0
        for i in range(1, 1+len(gas)):
            cumsum += (gas[i-1]-cost[i-1])
            if cumsum < minimum:
                minimum, min_idx = cumsum, i
        return min_idx if cumsum >= 0 else -1

本题关键在于利用题目给的条件：
只有唯一的解，如果一圈的油量足够走完一定有解，
并且cumsum最小的点才有可能是唯一的那个点。
