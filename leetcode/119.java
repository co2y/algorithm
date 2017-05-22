public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<=rowIndex; ++i) {

            for (int j=l.size()-1; j>=1; --j) {
                l.set(j, l.get(j)+l.get(j-1));
            }

            l.add(1);
        }
        return l;
    }
}
