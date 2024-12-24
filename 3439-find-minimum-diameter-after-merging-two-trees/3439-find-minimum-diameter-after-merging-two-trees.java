class Solution {

    List<List<Integer>> build(int size, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<size; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    int find(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] deg = new int[n];

        for(int i = 0; i<n; i++) {
            deg[i] = adj.get(i).size();
            if(deg[i] == 1) q.offer(i);
        }

        int rem = n;
        int leavesLayersRem = 0;

        while(rem > 2) {
            int s = q.size();
            rem -= s;
            leavesLayersRem++;

            for(int i = 0; i<s; i++) {
                int curr = q.poll();

                for (int nei : adj.get(curr)) {
                    deg[nei]--;
                    if (deg[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        if(rem == 2) return 2 * leavesLayersRem + 1;
        return 2 * leavesLayersRem;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> adj1 = build(n, edges1);
        List<List<Integer>> adj2 = build(m, edges2);

        int dia1 = find(n, adj1);
        int dia2 = find(m, adj2);

        int combD = (int) Math.ceil(dia1 / 2.0) + (int) Math.ceil(dia2 / 2.0) + 1;

        return Math.max(Math.max(dia1, dia2), combD);
    }
}