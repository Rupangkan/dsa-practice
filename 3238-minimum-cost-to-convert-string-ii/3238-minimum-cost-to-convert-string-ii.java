class Trie {
    Trie[] c = new Trie[26];
    int id = -1;
}

class Solution {

    static final int INF = 1 << 29;

    int add(Trie t, String s, int[] idx) {
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (t.c[x] == null) t.c[x] = new Trie();
            t = t.c[x];
        }
        if (t.id == -1) t.id = ++idx[0];
        return t.id;
    }

    public long minimumCost(String s, String t, String[] o, String[] c, int[] cost) {
        int n = s.length(), m = o.length;
        Trie root = new Trie();
        int[] idx = { -1 };

        int[][] g = new int[2 * m][2 * m];
        for (int i = 0; i < 2 * m; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = add(root, o[i], idx);
            int b = add(root, c[i], idx);
            g[a][b] = Math.min(g[a][b], cost[i]);
        }

        int sz = idx[0] + 1;
        for (int k = 0; k < sz; k++)
            for (int i = 0; i < sz; i++)
                for (int j = 0; j < sz; j++)
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);

        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[i - 1] == -1) continue;
            long base = i == 0 ? 0 : dp[i - 1];

            if (s.charAt(i) == t.charAt(i)) {
                dp[i] = dp[i] == -1 ? base : Math.min(dp[i], base);
            }

            Trie a = root, b = root;
            for (int j = i; j < n; j++) {
                a = a.c[s.charAt(j) - 'a'];
                b = b.c[t.charAt(j) - 'a'];
                if (a == null || b == null) break;
                if (a.id != -1 && b.id != -1 && g[a.id][b.id] < INF) {
                    long v = base + g[a.id][b.id];
                    dp[j] = dp[j] == -1 ? v : Math.min(dp[j], v);
                }
            }
        }

        return dp[n - 1];
    }
}
