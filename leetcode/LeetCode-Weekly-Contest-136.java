// 1041. Robot Bounded In Circle

class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dirctions = new int[][] {{0,1}, {-1,0}, {0,-1}, {1,0}};
        int[] now = new int[]{0, 0};
        int dir = 0;
        for (int i = 0; i < 100; i++) {
            for (char ch : instructions.toCharArray()) {
                if (ch == 'G') {
                    now[0] += dirctions[dir][0];
                    now[1] += dirctions[dir][1];
                } else if (ch == 'L') {
                    dir = dir - 1;
                    if (dir == -1) {
                        dir = 3;
                    }
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            if (now[0] == 0 && now[1] == 0) {
                return true;
            }
        }
        
        return false;
    }
}

// 1042. Flower Planting With No Adjacent
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Set<Integer>> maps = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            maps.add(new HashSet<>());
        }
        for (int[] path: paths) {
            maps.get(path[0]-1).add(path[1]-1);
            maps.get(path[1]-1).add(path[0]-1);
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i) {
            pick(i, maps, ans);
        }
        
        for (int i = 0; i < N; ++i) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
    
    private void pick(int now, List<Set<Integer>> maps, int[] ans) {
        Set<Integer> candidates = new HashSet<>();
        candidates.add(1);
        candidates.add(2);
        candidates.add(3);
        candidates.add(4);
        
        Set<Integer> s = maps.get(now);
        
        for (int c : s) {
            if (ans[c] != 0) {
                candidates.remove(ans[c]);
            }
        }
        
        ans[now] = candidates.iterator().next();
    }
}

// 1043. Partition Array for Maximum Sum
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n+1];
        
        for (int i = 1; i <= n; ++i) {
            int maxx = 0;
            
            for (int j = 1; j <= K && j <= i; j++) {
                maxx = Math.max(maxx, A[i-j]);
                dp[i] = Math.max(dp[i], maxx * j + dp[i-j]);
            }
        }
        
        return dp[n];
    }
}
