class Solution {

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;

                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    if (!uf.u(id, (i - 1) * n + j)) return true;
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    if (!uf.u(id, i * n + j - 1)) return true;
                }
            }
        }
        return false;
    }
}

class UF {

    int[] p, sz;

    UF(int n) {
        p = new int[n];
        sz = new int[n];
        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++) p[i] = i;
    }

    int f(int x) {
        if (p[x] != x) p[x] = f(p[x]);
        return p[x];
    }

    boolean u(int a, int b) {
        a = f(a);
        b = f(b);
        if (a == b) return false;

        if (sz[a] < sz[b]) {
            int t = a; a = b; b = t;
        }
        p[b] = a;
        sz[a] += sz[b];
        return true;
    }
}