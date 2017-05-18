class Solution(object):

    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        required, min_len = [0] * 256, 2147483647
        # record numbers of each character in t
        for ch in t:
            required[ord(ch)] += 1
        start = min_start = 0
        # count: number of characters that are still required
        count = len(required) - required.count(0)
        '''
        Record numbers of each character required.
        Scan s
        1. Decrease number of character required for current character
        2. If all values are non-positive, we have a window containing all characters in t.
        3. By scanning s from the start of the window increasing the number of character required, till we encounter a positive value,
           we have reduced the current window to its minimal size.
        4. Now compare the window size with the stored minimal one and update minimal one if neccessary.
           go back to step 1.
        '''
        for i in xrange(len(s)):
            # Decrease requied number of current character
            index = ord(s[i])
            required[index] -= 1
            if required[index] == 0:
                if count == 1:
                    # last one required
                    for j in xrange(start, i + 1):
                        # remove characters from start
                        index = ord(s[j])
                        required[index] += 1
                        if required[index] > 0:
                            # can't reduce size of current window, check if it
                            # is the minimal one
                            length = i - j
                            if length < min_len:
                                min_len = length
                                min_start = j
                            start = j + 1
                            break
                else:
                    # Decrease number of required characters
                    count -= 1

        return s[min_start: min_start + min_len + 1] if min_len != 2147483647 else ''
