def wordPattern(self, pattern, str):
    s = pattern
    t = str.split()
    return map(s.find, s) == map(t.index, t)

# s是str s.find返回第一个字符出现的index
# t是list t.index相当于str.find，返回某一个元素第一次出现的index



def wordPattern(self, pattern, str):
    f = lambda s: map({}.setdefault, s, range(len(s)))
    return f(pattern) == f(str.split())

# dict.setdefault(key, default) map函数的意思是把s中的每一个元素放到字典中，如果不存在默认值就是下标



def wordPattern(self, pattern, str):
    s = pattern
    t = str.split()
    return len(set(zip(s, t))) == len(set(s)) == len(set(t)) and len(s) == len(t)
