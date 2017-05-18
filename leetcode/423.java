public class Solution {
    public String originalDigits(String s) {
        //  three  nine
        int[] count = new int[26];
        for (char ch: s.toCharArray()) {
            count[ch-'a']++;
        }

        int[] ans = new int[10];
        int c0 = count['z'-'a'];
        if (c0>0) {
            ans[0] += c0;
            count['z'-'a'] = 0;
            count['e'-'a'] -= c0;
            count['r'-'a'] -= c0;
            count['o'-'a'] -= c0;
        }

        int c6 = count['x'-'a'];
        if (c6>0) {
            ans[6] += c6;
            count['s'-'a'] -= c6;
            count['i'-'a'] -= c6;
            count['x'-'a'] = 0;
        }

        int c7 = count['s'-'a'];
        if (c7>0) {
            ans[7] += c7;
            count['s'-'a'] = 0;
            count['e'-'a'] -= c7*2;
            count['v'-'a'] -= c7;
            count['n'-'a'] -= c7;
        }

        int c5 = count['v'-'a'];
        if (c5>0) {
            ans[5] += c5;
            count['f'-'a'] -= c5;
            count['i'-'a'] -= c5;
            count['v'-'a'] = 0;
            count['e'-'a'] -= c5;
        }

        int c4 = count['f'-'a'];
        if (c4>0) {
            ans[4] += c4;
            count['f'-'a'] = 0;
            count['o'-'a'] -= c4;
            count['u'-'a'] -= c4;
            count['r'-'a'] -= c4;
        }

        int c2 = count['w'-'a'];
        if (c2>0) {
            ans[2] += c2;
            count['t'-'a'] -= c2;
            count['w'-'a'] = 0;
            count['o'-'a'] -= c2;
        }

        int c1 = count['o'-'a'];
        if (c1>0) {
            ans[1] += c1;
            count['o'-'a'] = 0;
            count['n'-'a'] -= c1;
            count['e'-'a'] -= c1;
        }

        int c8 = count['g'-'a'];
        if (c8>0) {
            ans[8] += c8;
            count['e'-'a'] -= c8;
            count['i'-'a'] -= c8;
            count['g'-'a'] = 0;
            count['h'-'a'] -= c8;
            count['t'-'a'] -= c8;
        }

        ans[3] = count['t'-'a'];
        ans[9] = count['i'-'a'];

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<=9;++i) {
            if (ans[i]>0) {
                for(int j=0;j<ans[i];++j) sb.append(i+"");
            }
        }

        return sb.toString();
    }
}
