class Solution {
    public int minimumTeachings(int n, int[][] lang, int[][] fr) {
        Set<Integer> bad = new HashSet<>();
        for (int[] f : fr) {
            Set<Integer> s = new HashSet<>();
            for (int x : lang[f[0]-1]) s.add(x);
            boolean ok = false;
            for (int y : lang[f[1]-1]) if (s.contains(y)) { ok = true; break; }
            if (!ok) { bad.add(f[0]-1); bad.add(f[1]-1); }
        }
        int[] cnt = new int[n+1];
        int best = 0;
        for (int u : bad) {
            for (int x : lang[u]) {
                cnt[x]++;
                best = Math.max(best, cnt[x]);
            }
        }
        return bad.size()-best;
    }
}
