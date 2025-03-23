class Solution {
    final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> g = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );
        long[] st = new long[n];
        Arrays.fill(st, Long.MAX_VALUE);
        int[] c = new int[n];
        st[0] = 0;
        c[0] = 1;

        pq.offer(new long[]{0, 0});

        for(int i = 0; i<n; i++) g.add(new ArrayList<>());

        for(int[] i: roads) {
            int s = i[0], e = i[1], tt = i[2];
            g.get(s).add(new int[] {e, tt});
            g.get(e).add(new int[] {s, tt});
        }    

        while(!pq.isEmpty()) {
            long[] t = pq.poll();
            long curr = t[0];
            int currN = (int) t[1];

            if(curr > st[currN]) continue;

            for(int[] nei: g.get(currN)) {
                int neiN = nei[0], rt = nei[1];

                if(curr + rt < st[neiN]) {
                    st[neiN] = curr + rt;
                    c[neiN] = c[currN];
                    pq.offer(new long[] {st[neiN], neiN});
                } else if(curr + rt == st[neiN]) {
                    c[neiN] = (c[neiN] + c[currN]) % MOD;
                }
            }
        }

        return c[n-1];
    }
}