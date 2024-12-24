class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if(n < 2) return 1;

        int comp = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[n];

        for(int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e: edges) {
            int n1 = e[0], n2 = e[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            inDeg[n1]++;
            inDeg[n2]++;
        }

        long[] vals = new long[n];
        for(int i = 0; i<n; i++) {
            vals[i] = values[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if(inDeg[i] == 1) q.offer(i);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            inDeg[curr]--;
            long addVal = 0;

            if(vals[curr] % k == 0) comp++;
            else addVal = vals[curr];

            for(int nei: graph.get(curr)) {
                if(inDeg[nei] == 0) {
                    continue;
                }
                inDeg[nei]--;
                vals[nei] += addVal;

                if(inDeg[nei] == 1) q.offer(nei);
            }
        }

        return comp;
    }
}