public class Solution {
    public int smallestFactorization(int a) {

        if (a < 10) return a;

        LinkedList<Integer> al = new LinkedList<>();
        for (int i=9; i>1; --i) {
            while (a % i == 0) {
                a = a/i;
                al.addFirst(i);
            }
            if (a == 1) break;
        }

        if (a != 1) return 0;

        long res = 0;
        for (int i:al) {
            res = res*10 + i;
            if (res > Integer.MAX_VALUE) return 0;
        }

        return (int)res;

    }
}
