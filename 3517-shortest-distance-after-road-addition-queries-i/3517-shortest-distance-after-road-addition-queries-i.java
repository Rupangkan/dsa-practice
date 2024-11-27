class Solution {
    int solve(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        int currLayerNodeC = 1, nextLayerNodeC = 0, exp = 0;

        while(!q.isEmpty()) {
            for(int i = 0; i<currLayerNodeC; i++) {
                int currN = q.poll();
                if(currN == n-1) return exp;

                for(int nei: adj.get(currN)) {
                    if(vis[nei]) continue;
                    q.add(nei);
                    nextLayerNodeC++;
                    vis[nei] = true;
                }
            }
            currLayerNodeC = nextLayerNodeC;
            nextLayerNodeC = 0;
            exp++;
        }

        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(n);

        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<n-1; i++) {
            adj.get(i).add(i+1);
        }

        for(int[] r: queries) {
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            ans.add(solve(n, adj));
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}