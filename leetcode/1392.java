class Solution {
    public String longestPrefix(String s) {
        int[] next = getNext(s.toCharArray());
        // for (int n:next) {
        //     System.out.println(n);
        // }
        if (s.length() == 1) return "";
        return s.substring(s.length()-next[next.length-1]);
    }
    
    private int[] getNext(char[] chars) {
        int n = chars.length;
        int[] next = new int[n+1];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < n) {
            if (k == -1 || chars[j] == chars[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}