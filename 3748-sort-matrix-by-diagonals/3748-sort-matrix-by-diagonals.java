class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> d = new ArrayList<>();
            for (int j = 0; i + j < n; j++) d.add(grid[i + j][j]);
            d.sort((a, b) -> b - a);
            for (int j = 0; i + j < n; j++) grid[i + j][j] = d.get(j);
        }
        for (int j = 1; j < n; j++) {
            List<Integer> d = new ArrayList<>();
            for (int i = 0; j + i < n; i++) d.add(grid[i][j + i]);
            Collections.sort(d);
            for (int i = 0; j + i < n; i++) grid[i][j + i] = d.get(i);
        }
        return grid;
    }
}
