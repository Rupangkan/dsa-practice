class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m / 2, n / 2);

        for (int l = 0; l < layers; l++) {
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            List<Integer> v = new ArrayList<>();

            for (int i = l; i < m - l - 1; i++) {
                x.add(i);
                y.add(l);
                v.add(grid[i][l]);
            }

            for (int j = l; j < n - l - 1; j++) {
                x.add(m - l - 1);
                y.add(j);
                v.add(grid[m - l - 1][j]);
            }

            for (int i = m - l - 1; i > l; i--) {
                x.add(i);
                y.add(n - l - 1);
                v.add(grid[i][n - l - 1]);
            }

            for (int j = n - l - 1; j > l; j--) {
                x.add(l);
                y.add(j);
                v.add(grid[l][j]);
            }

            int sz = v.size();
            int d = k % sz;

            for (int i = 0; i < sz; i++) {
                int p = (i + sz - d) % sz;
                grid[x.get(i)][y.get(i)] = v.get(p);
            }
        }

        return grid;
    }
}