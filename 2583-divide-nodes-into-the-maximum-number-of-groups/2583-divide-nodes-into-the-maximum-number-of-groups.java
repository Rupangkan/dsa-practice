class Solution {

    int bfs(int s, List<List<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] lvl = new int[n];
        Arrays.fill(lvl, -1);

        q.offer(s);
        lvl[s] = 0;
        int maxD = 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int u = q.poll();
                for(int v: adj.get(u)) {
                    if(lvl[v] == -1) {
                        lvl[v] = maxD + 1;
                        q.offer(v);
                    } else if(lvl[v] == maxD) return -1;
                }
            }
            maxD++;
        }

        return maxD;
    }

    int find(int x, int[] p) {
        return p[x] == -1 ? x : (p[x] = find(p[x], p));
    }

    void unite(int x, int y, int[] p, int[] d) {
        x = find(x, p);
        y = find(y, p);

        if(x == y) return;
        if(d[x] < d[y]) p[x] = y;
        else p[y] = x;

        if(d[x] == d[y]) d[x]++;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        Map<Integer, Integer> comp = new HashMap<>();
        int res = 0;

        int[] par = new int[n], d = new int[n];
        Arrays.fill(par, -1);

        for(int[] e: edges) {
           adj.get(--e[0]).add(--e[1]);
           adj.get(e[1]).add(e[0]);
           unite(e[0], e[1], par, d);
        }

        for(int i = 0; i<n; i++) {
            int grp = bfs(i, adj, n);
            if(grp == -1) return -1;
            int root = find(i, par);
            comp.put(root, Math.max(comp.getOrDefault(root, 0), grp));
        }

        return comp.values().stream().mapToInt(Integer::intValue).sum();
    }
}