#### Find in Mountain Array
```
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private HashMap<Integer, Integer> findMap = new HashMap<>();
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        int begin = mountainArr.get(0);
        int end = mountainArr.get(n-1);
        
        if (begin > target && end > target) return -1;
        
        int peekIndex = findPeekIndex(mountainArr, n);
        
        int left = 0;
        int right = peekIndex;
        
        // System.out.println(right);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int e = getOrPut(mid, mountainArr);
            if (e == target) {
                return mid;
            }
            
            else if (e > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        left = peekIndex + 1;
        right = n - 1;
        
        // System.out.println(left);
        while (left <= right) {
            int mid = (left + right) / 2;
            int e = getOrPut(mid, mountainArr);
            if (e == target) {
                return mid;
            }
            
            else if (e > target) {
                left = mid + 1;
                
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
        
    }
    
    
    private int findPeekIndex(MountainArray m, int n) {
        int left = 1;
        int right = n-1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int a = getOrPut(mid-1, m);
            int b = getOrPut(mid, m);
            int c = getOrPut(mid+1, m);
            if (a < b && b > c) {
                return mid;
            } else if (a < b && b < c) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int getOrPut(int index, MountainArray m) {
        int ret;
        if (findMap.containsKey(index)) {
            ret = findMap.get(index);
        } else {
            ret = m.get(index);
            findMap.put(index, ret);
        }
        return ret;
    }
} 
```

#### Brace Expansion II
```
class Solution {
    public List<String> braceExpansionII(String expression) {
        ArrayList<StringBuilder> h = helper(expression, new WrapperInt());
        List<String> ret = h.stream().map(x -> x.toString()).collect(Collectors.toSet()).stream().collect(Collectors.toList());
        
        Collections.sort(ret);
        return ret;
    }
    
    private ArrayList<StringBuilder> helper(String expression, WrapperInt p) {

        ArrayList<StringBuilder> oneCompleteBrace = new ArrayList<>();
        ArrayList<StringBuilder> result = new ArrayList<>();
        oneCompleteBrace.add(new StringBuilder(""));

        while (p.index < expression.length()) {
            if (expression.charAt(p.index) == '{') {
                p.advance();
                ArrayList<StringBuilder> nextCompleteBrace = helper(expression, p);
                ArrayList<StringBuilder> combineCompleteBrace = new ArrayList<>();

                // cartesian
                for (StringBuilder e : oneCompleteBrace) {
                    for (StringBuilder t : nextCompleteBrace) {
                        StringBuilder s = new StringBuilder(e);
                        combineCompleteBrace.add(s.append(t));
                    }
                }
                oneCompleteBrace = combineCompleteBrace;


            } else if (expression.charAt(p.index) == ',') {
                result.addAll(oneCompleteBrace);
                oneCompleteBrace.clear();
                oneCompleteBrace.add(new StringBuilder(""));
                p.advance();
            } else if (expression.charAt(p.index) == '}') {
                p.advance();
                result.addAll(oneCompleteBrace);

                return result;
            } else {
                for (StringBuilder sb : oneCompleteBrace) {
                    sb.append(expression.charAt(p.index));
                }
                p.advance();
            }
        }

        return oneCompleteBrace;
    }
    
    private static class WrapperInt {
        public WrapperInt() {
            index = 0;
        }

        public int advance() {
            index++;
            return index;
        }

        public int index;
    }

}
```
