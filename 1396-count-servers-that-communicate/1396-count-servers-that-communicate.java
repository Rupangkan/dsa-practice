class Solution {
    public int countServers(int[][] grid) {
        int count = 0, n = grid.length, m = grid[0].length;
        int[] row = new int[n]; 
        int[] col = new int[m]; 


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}