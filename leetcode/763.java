class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> index = new HashMap<>();
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            index.put(chs[i], i);
        }
        
        List<Integer> ans = new LinkedList<>();
        int now = 0;
        while (now < chs.length) {
            int i = now;
            int temp = 0;
            for (;;) {
                temp++;
                now = Math.max(now, index.get(chs[i]));
                if (now == i) {
                    now++;
                    break;
                }
                i++;
            }
            // System.out.println(temp);
            ans.add(temp);
        }
        
        return ans;
    }
}