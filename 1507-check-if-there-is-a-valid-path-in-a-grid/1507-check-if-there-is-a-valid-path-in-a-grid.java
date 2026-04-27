class Solution {

    class DSU {
        int[] p;

        DSU(int m, int n) {
            p = new int[m * n];
            for (int i = 0; i < m * n; i++) p[i] = i;
        }

        int f(int x) {
            if (p[x] != x) p[x] = f(p[x]);
            return p[x];
        }

        void u(int a, int b) {
            p[f(a)] = f(b);
        }
    }

    int[] pat = {0, 0b1010, 0b0101, 0b1100, 0b0110, 0b1001, 0b0011};
    int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    int[][] g;
    int m, n;
    DSU dsu;

    public boolean hasValidPath(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        dsu = new DSU(m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                go(i, j);
            }
        }

        return dsu.f(id(0, 0)) == dsu.f(id(m - 1, n - 1));
    }

    int id(int x, int y) {
        return x * n + y;
    }

    void go(int x, int y) {
        int p = pat[g[x][y]];

        for (int i = 0; i < 4; i++) {
            if ((p & (1 << i)) == 0) continue;

            int nx = x + d[i][0], ny = y + d[i][1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            if ((pat[g[nx][ny]] & (1 << ((i + 2) % 4))) != 0) {
                dsu.u(id(x, y), id(nx, ny));
            }
        }
    }
}