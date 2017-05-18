public class Solution {
        public String reverseStr(String s, int k) {
                int n = s.length();
                StringBuilder sb = new StringBuilder();
                int mod = 2*k;
                StringBuilder reverse = new StringBuilder();
                for (int i=0; i<n; ++i) {
                        if (i%mod==k) {
                                sb.append(reverse.reverse().toString());
                                reverse = new StringBuilder();
                        }
                        if (i%mod<k) {
                                reverse.append(s.charAt(i));
                        }
                        else {
                                sb.append(s.charAt(i));
                        }
                }
                return sb.append(reverse.reverse().toString()).toString();
        }
}
