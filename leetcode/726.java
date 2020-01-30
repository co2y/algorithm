class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        int num = 0;
        int numIndex = 0;
        int multi = 1;
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> count = new TreeMap<>();
        for (int i = n-1 ; i>=0; --i) {
            char ch = formula.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num + (int)Math.pow(10, numIndex) * (ch - '0');
                numIndex++;
            } else if (ch == ')') {
                multi = multi * num;
                s.push(num);
                num = 0;
                numIndex = 0;
            } else if (ch == '(') {
                int p = s.pop();
                multi = multi / p;
                num = 0;
                numIndex = 0;
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch);
                String key = sb.reverse().toString();
                if (num == 0) {
                    count.put(key, count.getOrDefault(key, 0) + multi);
                } else {
                    count.put(key, count.getOrDefault(key, 0) + num * multi);
                }
                num = 0;
                numIndex = 0;
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        
        return serialize(count);
    }
    
    private void merge(Map<String, Integer> m1, Map<String, Integer> m2) {
        for (Map.Entry<String, Integer> entry: m2.entrySet()) {
            String key = entry.getKey();
            m1.put(key, m1.getOrDefault(key,0) + entry.getValue());
        }
    }
    
    private String serialize(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1)
                sb.append(entry.getValue());
        }
        return sb.toString();
    }
    
    private Map<String, Integer> getCount(String s) {
        Map<String, Integer> count = new TreeMap<>();
        
        int n = s.length();
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            int num = 0;
            
            while(true) {
                i++;
                if (i==n) break;
                ch = s.charAt(i);
                while (i < n && (ch >= 'a' && ch <= 'z')) {
                    sb.append(ch);
                    i++;
                    if (i==n) break;
                    ch = s.charAt(i);
                }
                
                while (i < n && (ch >= '0' && ch <= '9')) {
                    num = num * 10 + (ch - '0');
                    i++;
                    if (i==n) break;
                    ch = s.charAt(i);
                }
                break;
            }
            
            String key = sb.toString();
            if (num == 0) {
                count.put(key, count.getOrDefault(key,0) + 1);
            } else {
                count.put(key, count.getOrDefault(key,0) + num);
            }
        }
        
        return count;
    }
}