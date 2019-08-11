### A

```
class Solution {
    public int dayOfYear(String date) {
        String[] tokens = date.split("-");
        
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int days = Integer.parseInt(tokens[2]);
        int ret = 0;
        for (int i = 1; i < month; ++i) {
            ret += dayOfMonth[i-1];
        }
        ret += days;
        
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 ) ) {
            if (month > 2)
                ret++;
        }
        
        
        return ret;
    }
}
```


### B

```
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d+1][target+1];
        int mod = 1000000007;
        for (int i = 1; i <= f && i <= target; ++i) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= d; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int k = 1; k <=f ; ++k) {
                    if (j-k>0 && dp[i-1][j-k]>0) {
                        dp[i][j] = (dp[i][j]+dp[i-1][j-k])  % mod; 
                    }
                }
                
            }
        }
        
        return (int)dp[d][target];
    }
}
```

### C

```
class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] index = new int[n];
        
        for (int i = 0; i < n; ++i) {
            index[i] = text.charAt(i)-'a';
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            List<int[]> intervals = new ArrayList<>();
            boolean begin = true;
            for (int j = 0; j < n; ++j) {
                if (begin && index[j] == i) {
                    intervals.add(new int[2]);
                    intervals.get(intervals.size() - 1)[0] = j;
                    begin = false;
                    continue;
                }
                if (!begin&&index[j] == i) {
                    continue;
                } else if (!begin){
                    begin = true;
                    intervals.get(intervals.size() - 1)[1] = j-1;
                }
            }
            
            if (!begin) {
                intervals.get(intervals.size() - 1)[1] = n-1;
            }
            
            // System.out.println(intervals);
            int ret = calc(intervals);
            // System.out.println(ret);
            ans = Math.max(ans, ret);
        }
        
        return ans;
        
    }
    
    
    private int calc(List<int[]> vals) {
        int ret = 0;
        for (int[] v: vals) {
            int tmp = v[1] - v[0] + 1;
            ret = Math.max(ret, tmp);
        }
        
        int n = vals.size();
        if (n > 1) {
            ret++;
        }
        for (int i = 1; i < n; ++i) {
            if (vals.get(i)[0] - vals.get(i-1)[1] == 2) {
                if (n > 2)
                    ret = Math.max(ret, vals.get(i)[1] - vals.get(i)[0] + vals.get(i-1)[1] - vals.get(i-1)[0] + 3);
                else 
                    ret = Math.max(ret, vals.get(i)[1] - vals.get(i)[0] + vals.get(i-1)[1] - vals.get(i-1)[0] + 2);
            }   
        }
        
        return ret;
    }
}
```

### D

```

```