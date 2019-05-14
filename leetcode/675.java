class Solution {
    int[][] direct = {{1, 0},{-1, 0},{0, -1},{0, 1}};
    int[][] distance;
    public int cutOffTree(List<List<Integer>> forest) {
    	int result = 0;
    	int rows = forest.size();
    	int cols = forest.get(0).size();
    	int[][] matrix = new int[rows][cols];
    	
    	TreeMap<Integer,int[]> map = new TreeMap<Integer,int[]> ();
    	distance = new int[rows][cols];
    	
    	for(int i=0;i<rows;i++)
    		for(int j=0;j<cols;j++){
    			matrix[i][j] = forest.get(i).get(j);
    			map.put(matrix[i][j],new int[]{i,j});
    		}
    	
    	
    	Set<Integer> keys = map.keySet();
    	
    	int[] start = {0,0};
    	for(int key : keys){
    		if(key > 0){
    			int[] end = map.get(key);
    			getDistance(start,matrix);
    			int d = distance[end[0]][end[1]];
    			if(d == Integer.MAX_VALUE)
    				return -1;
    			result += d;
    			start = end;
    		}
    	}
    	return result;
    }
    
    
    void getDistance(int[] start,int[][] matrix){
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
    	// init 
    	for(int i=0;i<rows;i++)
    		for(int j=0;j<cols;j++)
    			distance[i][j] = Integer.MAX_VALUE;
    	
    	
    	Queue<int[]> q = new LinkedList<int[]>();
    	q.add(start);
    	distance[start[0]][start[1]] = 0;
    	
    	while(!q.isEmpty()){
    		int[] p = q.poll();
    		
    		for(int[] dir : direct ){
    			int x = p[0];
    			int y = p[1];
    			int nx = x + dir[0];
    			int ny = y + dir[1];
    			int[] np = {nx,ny};
    			
    			if(nx<rows && nx>=0 && ny<cols && ny>=0 && matrix[nx][ny]!=0
    					&& distance[nx][ny]>distance[x][y]+1){
    				q.add(np);
    				distance[nx][ny] = distance[x][y] + 1;
    			}
    		}
    		
    	}
    	
    }
}