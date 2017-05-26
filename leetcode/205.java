public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] ss = new int[256];
        int[] tt = new int[256];

        if (s.length() != t.length() ) return false;

        for (int i=0; i<s.length(); ++i) {
            if (ss[t.charAt(i)] != tt[s.charAt(i)]) return false;

            ss[t.charAt(i)] = i+1;
            tt[s.charAt(i)] = i+1;
        }
        return true;
    }
}
