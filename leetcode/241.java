public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        int n = input.length();
        for (int i=0; i<n; ++i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i+1, n);

                List<Integer> ll = diffWaysToCompute(left);
                List<Integer> rl = diffWaysToCompute(right);

                for (int l: ll) {
                    for (int r: rl) {
                        if (c == '+') {
                            res.add(l+r);
                        } else if (c == '-') {
                            res.add(l-r);
                        } else {
                            res.add(l*r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}
