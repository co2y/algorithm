public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for (int num: nums ) {
            if (hm.containsKey(num)){
                return true;
            }
            else{
                hm.put(num, 0);
            }
        }
        return false;
    }
}
