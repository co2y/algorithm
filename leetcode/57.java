class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), 
                                    Math.max(intervals[i][1], newInterval[1]) };
            i++;
        }
        ans.add(newInterval);
        
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }
        
        int[][] ret = new int[ans.size()][2];
        
        for (int j = 0 ; j < ans.size(); ++j) {
            ret[j] = ans.get(j);
        }
        return ret;
    }
}