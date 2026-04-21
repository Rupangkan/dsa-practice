class Solution {

    private int[] p, r;

    private int f(int x) {
        if (p[x] != x) p[x] = f(p[x]);
        return p[x];
    }

    private void u(int a, int b) {
        a = f(a);
        b = f(b);
        if (a == b) return;

        if (r[a] < r[b]) {
            int t = a; a = b; b = t;
        }
        p[b] = a;
        if (r[a] == r[b]) r[a]++;
    }

    public int minimumHammingDistance(
        int[] source,
        int[] target,
        int[][] allowedSwaps
    ) {
        int n = source.length;
        p = new int[n];
        r = new int[n];

        for (int i = 0; i < n; i++) p[i] = i;

        for (int[] e : allowedSwaps) u(e[0], e[1]);

        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = f(i);
            mp.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> cnt = mp.get(root);
            cnt.put(source[i], cnt.getOrDefault(source[i], 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int root = f(i);
            Map<Integer, Integer> cnt = mp.get(root);

            int v = target[i];
            if (cnt.getOrDefault(v, 0) > 0) {
                cnt.put(v, cnt.get(v) - 1);
            } else {
                ans++;
            }
        }

        return ans;
    }
}