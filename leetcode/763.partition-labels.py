#
# @lc app=leetcode id=763 lang=python3
#
# [763] Partition Labels
#
# https://leetcode.com/problems/partition-labels/description/
#
# algorithms
# Medium (69.29%)
# Total Accepted:    41.7K
# Total Submissions: 60K
# Testcase Example:  '"ababcbacadefegdehijhklij"'
#
# 
# A string S of lowercase letters is given.  We want to partition this string
# into as many parts as possible so that each letter appears in at most one
# part, and return a list of integers representing the size of these parts.
# 
# 
# Example 1:
# 
# Input: S = "ababcbacadefegdehijhklij"
# Output: [9,7,8]
# Explanation:
# The partition is "ababcbaca", "defegde", "hijhklij".
# This is a partition so that each letter appears in at most one part.
# A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
# splits S into less parts.
# 
# 
# 
# Note:
# S will have length in range [1, 500].
# S will consist of lowercase letters ('a' to 'z') only.
# 
#
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        index_map = {}
        n = len(S)
        for i in range(n):
            if S[i] in index_map:
                index_map[S[i]].append(i)
            else:
                index_map[S[i]] = [i]
        
        i_start = 0
        ans = []
        while True:
            i_end = index_map[S[i_start]][-1]
            
            def get(x, y):
                tmp_end = -1
                for z in range(x, y+1):
                    if index_map[S[z]][-1] <= y:
                        continue
                    else:
                        tmp_end = index_map[S[z]][-1]
                        break
                if tmp_end == -1:
                    return y
                else:
                    return get(z, tmp_end)
                
            
            j = get(i_start, i_end)
            ans.append(j-i_start+1)

            if j < n-1:    
                i_start = j+1
            else:
                break

        return ans
            

