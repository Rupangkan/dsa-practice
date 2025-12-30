class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i + 2 < m; i++)
            for (int j = 0; j + 2 < n; j++)
                if (isMagic(grid, i, j)) ans++;
        return ans;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        if (g[r + 1][c + 1] != 5 || g[r][c] % 2 == 1) return false;

        String s1 = "2943816729438167";
        String s2 = "7618349276183492";

        int[] idx = {0,1,2,5,8,7,6,3};
        StringBuilder sb = new StringBuilder();
        for (int k : idx)
            sb.append(g[r + k / 3][c + k % 3]);

        String b = sb.toString();
        return s1.contains(b) || s2.contains(b);
    }
}
