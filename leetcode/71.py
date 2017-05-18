class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        flag = 1 if path.startswith('/') else 0
        l = path.split('/')
        result = []
        for each in l:
            if each:
                if each == '..' and result:
                    result.pop()
                elif each == '..' and not result:
                    continue
                elif each == '.':
                    continue
                else:
                    result.append(each)

        return '/'+'/'.join(result) if flag else '/'.join(result)
        
s = Solution()
print s.simplifyPath("/home/")
print s.simplifyPath("/a/./b/../../c/")
print s.simplifyPath("/../")
print s.simplifyPath("/home//foo/")