public class Solution {
     public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; --i) {
            char c = S.charAt(i);
            if (c != '-') {
                if (count == K) {
                    count = 1;
                    sb.append('-').append(c);
                } else {
                    sb.append(c);
                    count++;
                }
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
