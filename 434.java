public class Solution {
    public int countSegments(String s) {
        return s.trim().length()==0?0:s.trim().split("\\s+").length;

    }
}
