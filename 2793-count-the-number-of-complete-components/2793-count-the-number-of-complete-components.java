class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        boolean[] vis = new boolean[n];
        int complete = 0;

        for(int i = 0; i<n; i++) g[i] = new ArrayList<>();
        for(int[] e: edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                List<Integer> comp = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    comp.add(curr);

                    for(int nei: g[curr]) {
                        if(!vis[nei]) {
                            q.add(nei);
                            vis[nei] = true;
                        }
                    }
                }

                boolean isC = true;
                for(int node: comp) {
                    if(g[node].size() != comp.size() - 1) {
                        isC = false;
                        break;
                    }
                }

                if(isC) complete++;
            }
        }


        return complete;
    }
}