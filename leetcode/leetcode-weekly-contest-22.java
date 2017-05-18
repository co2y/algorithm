public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k<0 ) return 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int num : nums) {
            if (hs.containsKey(num))
                hs.put(num, hs.get(num) + 1);
            else
                hs.put(num, 1);
        }

        Arrays.sort(nums);

        int pre = nums[nums.length - 1] + 1;
        int ans = 0;
        for (int num : nums) {
            if (num == pre) continue;

            pre = num;
            if (k == 0 && hs.get(num + k) > 1) ans++;
            if (k != 0 && hs.containsKey(num + k)) ans++;
        }
        return ans;
    }
}

public class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int m = picture.length;
        int n = picture[0].length;

        int ans = 0;
        boolean[] rows = new boolean[m];
        for (int i = 0; i < m; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    count++;
                    if (count == 2) {
                        rows[i] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            int count = 0;
            int row = 0;
            for (int j = 0; j < m; ++j) {
                if (picture[j][i] == 'B') {
                    count++;
                    row = j;
                    if (count == 2) {
                        break;
                    }
                }
            }
            if (count==1 && !rows[row]) ans++;
        }

        return ans;
    }
}


public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int m = picture.length;
        int n = picture[0].length;

        int ans = 0;
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                }
            }
        }

        int[] cols = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (picture[j][i] == 'B') {
                    cols[i]++;
                }
            }

        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rows[i] != cols[j] || rows[i]!=N || picture[i][j]!='B') continue;

                boolean flag = true;
                int count = 0;
                for (int k = 0; k < m; ++k) {
                    if (picture[k][j] == 'B') {

                        count++;
                        if (!rowcompare(picture,k,i)) {
                            flag = false;
                            break;
                        }

                    }
                }

                if (flag) ans += count;
            }
        }

        return ans/N;
    }

    public boolean rowcompare(char[][] picture, int k, int i) {
        for(int j=0; j<picture[k].length; j++) {
            if (picture[k][j]!=picture[i][j]) return false;
        }
        return true;
    }
}
