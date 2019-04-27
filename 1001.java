class Solution {
    private Map<Integer, Integer> horizon = new HashMap<>();
    private Map<Integer, Integer> vertical = new HashMap<>();
    private Map<Integer, Integer> l_oblique = new HashMap<>();
    private Map<Integer, Integer> r_oblique = new HashMap<>();
    
    private Set<Light> lights = new HashSet<>();
    
    private static int n;
    
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        n = N;
        for (int i = 0; i < lamps.length; ++i) {
            int x = lamps[i][0];
            int y = lamps[i][1];
            lights.add(new Light(x, y));
            horizon.put(x, horizon.getOrDefault(x, 0) + 1);
            vertical.put(y, vertical.getOrDefault(y, 0) + 1);
            l_oblique.put(x+y, l_oblique.getOrDefault(x+y, 0) + 1);
            r_oblique.put(x-y, r_oblique.getOrDefault(x-y, 0) + 1);
        }
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; ++i) {
            int x = queries[i][0];
            int y = queries[i][1];
            
            if (horizon.getOrDefault(x, 0) > 0 || vertical.getOrDefault(y, 0) > 0 
                || l_oblique.getOrDefault(x+y, 0) > 0 || r_oblique.getOrDefault(x-y,0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
            
            int[] dx = new int[]{-1, 0, 1};
            int[] dy = new int[]{-1, 0, 1};
            
            for (int xStep: dx) {
                for (int yStep : dy) {
                    int nx = x + xStep;
                    int ny = y + yStep;
                    Light l = new Light(nx, ny);
                    // 这里写根据hashCode计算同时根据equals比较
                    if (lights.contains(l)) {
                        // System.out.println("debug");
                        lights.remove(l);
                        horizon.put(nx, horizon.get(nx) - 1);
                        vertical.put(ny, vertical.get(ny) - 1);
                        l_oblique.put(nx+ny, l_oblique.get(nx+ny) - 1);
                        r_oblique.put(nx-ny, r_oblique.get(nx-ny) - 1);
                    }
                }
            }
        }
        
        return ans;
    }
    
    private static class Light {
        int xIndex;
        int yIndex;
        
        Light(int x, int y) {
            this.xIndex = x;
            this.yIndex = y;
        }
    
        @Override
        public int hashCode() {
            return xIndex + yIndex * n;
        }
        
        @Override
	    public boolean equals(Object other) {
		    // System.out.println("equals method invoked!");
		
		    if(other == this)
			    return true;
		    if(!(other instanceof Light))
			    return false;
		
		    Light o = (Light)other;
		    return o.xIndex == xIndex && o.yIndex == yIndex;
        }
    }

}