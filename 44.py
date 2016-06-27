（1）搜索
基本的搜索+回溯算法是这样的，对于原串s和模式串p，依次遍历其字符：

(a) 如果p[j]="*"，依次将p[j+1..p.length]和s[i..s.length]、s[i+1..s.length]、s[i+2..s.length]...匹配，如果全都失败了，将i和j回溯到上一个"*"号位置

(b) 如果s[i]="?"或s[i]=p[j]，说明当前字符匹配，此时i++,j++

(c) 否则，说明当前字符不匹配，回溯至上一个星号位置

可以看出，如果"*"很多，而且总是失败，那么算法的回溯代价是巨大的

 

优化的地方在于：对于情况(a)，如果当前匹配失败，就说明整个匹配失败了，不需要回溯至上一个星号处。

说白了就是，最多回溯到p串的上一个"*"号处，在往前的"*"不用管了。

例如：

   0 1 2 3 4 5 6 7 8 
s: a b c d a c c c
   | |  \ \ \ \
p: a b * c d * a c c
               |
              失配
上面的例子，s[5]!=p[6]，那么最多只需要回溯到第二个星号位置（p[5]="*"），不需要回溯到第一个星号位置（p[2]="*"）。因为回溯到更早的"*"不会产生新的匹配结果。（这个结论以后有机会证明一下）

C：
bool isMatch(const char *s, const char *p) {
  const char *star = NULL;
  const char *backup = NULL;
        
  while (*s) {
    if (*p == '*') {
      backup = s;
      star = ++p;
    }
    else if (*p == '?' || *p == *s) {
      s++;
      p++;
    }
    else if (star) {
      p = star;
      s = ++backup;
    }
    else
      break;
  }
        
  while (*p == '*')
    p++;
  return !*s && !*p;
}

Python：
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        i = 0
        j = 0
        backup = len(s)
        star = len(p)
        while i < len(s):
            
            if j < len(p) and p[j] == '*':
                backup = i
                star = j
                j += 1
            elif j < len(p) and (p[j] == '?' or p[j] == s[i]):
                i += 1
                j += 1
            elif star < len(p):
                j = star
                backup += 1
                i = backup
            else:
                break
            
        while j < len(p) and p[j] == '*':
            j+=1
        
        
        return (i==len(s)) and (j==len(p))


（2）DP
字符串的模板匹配，实质为字符串之间的比较。当我们比较s[i]和p[j]是否能够匹配时，可以通过s[0..i-1]与p[0..j-1]的匹配关系来推导。

如果我们已经知道s[0..i-1]和p[0..j-1]的匹配关系时，就可以很容易推导出s[0..i]和p[0..j]的匹配关系。其递推公式为：

当p[j]为*时，由于*可以考虑为0~n个任意字符，因此分为3种不同的情况：

s[i-1]和p[j-1]进行匹配，s[i]和p[j]进行匹配。此时考虑*表示1个字符。
s[i-1]已经和p[j]进行了匹配，s[i]也仍然和p[j]进行匹配。此时考虑*表示n个字符。
s[i]和p[j - 1]进行了匹配，此时考虑*表示0个字符。
当p[j]为?时：

s[i-1]和p[j-1]进行匹配，s[i]和p[j]进行匹配。
当p[j]为字母时：

s[i-1]和p[j-1]进行匹配，s[i]和p[j]进行匹配。
若我们使用f[i][j]表示s[0..i]和p[0..j]是否能够匹配，则上面的递推关系可以表示为：

f[i][j] = f[i-1][j-1] | f[i-1][j] | f[i][j - 1] (p[j] == '*')
f[i][j] = f[i-1][j-1] (p[j] == '?')
f[i][j] = f[i-1][j-1] && p[j] == s[i] (others)
需要注意的是边界条件：

f[i][0] = false;
f[0][0] = true;
但是对于f[0][j]需要特殊处理，当p[j]为*，f[0][j]的值可以等于f[0][j-1]，此时将*考虑为0个字符。

最后根据f[s.size()][p.size()]的值就可以判定s和p是否能够匹配。

