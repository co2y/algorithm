public class Solution {
    private boolean[][] used;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length==0) return false;
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];
        char[] w = word.toCharArray();
        for (int y=0; y<m; y++) {
        	for (int x=0; x<n; x++) {
        		if (exist(board, y, x, w, 0)) return true;
        	}
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    	if (i == word.length) return true;
    	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    	if (board[y][x] != word[i]) return false;
    	if (used[y][x]) return false;
    	used[y][x] = true;
    	boolean exist = exist(board, y, x+1, word, i+1)
    		|| exist(board, y, x-1, word, i+1)
    		|| exist(board, y+1, x, word, i+1)
    		|| exist(board, y-1, x, word, i+1);
    	used[y][x] = false;
    	return exist;
    }
}
