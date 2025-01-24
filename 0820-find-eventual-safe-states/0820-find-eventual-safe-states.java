class Solution {

    private boolean dfs(int u, int[][] g, boolean[] v, boolean[] s) {
        if (s[u]) return true;
        if (v[u]) return false;
        v[u] = s[u] = true;
        for (int nei : g[u])
            if (dfs(nei, g, v, s)) 
                return true;
        s[u] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        boolean[] v = new boolean[n], s = new boolean[n];
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) 
            if (!v[i]) 
                dfs(i, g, v, s);

        for (int i = 0; i < n; i++) 
            if (!s[i]) 
                res.add(i);
        
        return res;
    }
}