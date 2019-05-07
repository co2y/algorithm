class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int m = N % 14;
        if (m == 0) {
            m = 14;
        }
        for (int i = 0; i < m; ++i) {
            int[] tmp = new int[8];
            System.arraycopy(cells, 0, tmp, 0, 8);
            for (int j = 0; j < 8; ++j) {
                if (j == 0 || j == 7) {
                    cells[j] = 0;
                } else {
                    cells[j] = 1 - tmp[j-1] ^ tmp[j+1];
                }
                // System.out.println(cells[j]);
            }
            // System.out.println();
        }
        return cells;
    }
}


// Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
// Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
// Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
// Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
// Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
// Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
// Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
// Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
// Day 8: [0 0 0 0 0 1 1 0
// Day 9: [0 1 1 1 0 0 0 0
// Day10: [0 0 1 0 0 1 1 0
// Day11: [0 0 1 0 0 0 0 0
// Day12: [0 0 1 0 1 1 1 0
// Day13: [0 0 1 1 0 1 0 0
// Day14: [0 0 0 0 1 1 0 0
// Day15: [0 1 1 0 0 0 0 0