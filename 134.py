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
每次计算cumsum，如果当前节点的gas小于cost，说明之前的点不可能是唯一点，
下个点才有可能是起点，所以min_idx设置为i，这样一直循环下去，
直到找到某个点作为起始点，且该点的gas一定大于等于cost
