#
# @lc app=leetcode id=383 lang=python3
#
# [383] Ransom Note
#
# https://leetcode.com/problems/ransom-note/description/
#
# algorithms
# Easy (49.52%)
# Total Accepted:    107.3K
# Total Submissions: 216.6K
# Testcase Example:  '"a"\n"b"'
#
# 
# Given an arbitrary ransom note string and another string containing letters
# from all the magazines, write a function that will return true if the ransom 
# note can be constructed from the magazines ; otherwise, it will return
# false. 
# 
# 
# Each letter in the magazine string can only be used once in your ransom
# note.
# 
# 
# Note:
# You may assume that both strings contain only lowercase letters.
# 
# 
# 
# canConstruct("a", "b") -> false
# canConstruct("aa", "ab") -> false
# canConstruct("aa", "aab") -> true
# 
# 
#
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        from collections import Counter
        c1 = Counter(ransomNote)
        c2 = Counter(magazine)
        return c1 - c2 == {}

