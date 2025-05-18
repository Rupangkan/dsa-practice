class Solution {
    
    static final int mod = 1000000007;

    private int solve(int m, int n) {
        int lim = (int) Math.pow(3, m);
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < lim; i++) {
            List<Integer> c = new ArrayList<>();
            int x = i, ok = 1;
            for (int j = 0; j < m; j++) {
                c.add(x % 3);
                x /= 3;
            }
            for (int j = 1; j < m; j++) {
                if (c.get(j).equals(c.get(j - 1))) {
                    ok = 0;
                    break;
                }
            }
            if (ok == 1) mp.put(i, c);
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int a : mp.keySet()) {
            for (int b : mp.keySet()) {
                int valid = 1;
                for (int j = 0; j < m; j++) {
                    if (mp.get(a).get(j).equals(mp.get(b).get(j))) {
                        valid = 0;
                        break;
                    }
                }
                if (valid == 1) adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        for (int key : mp.keySet()) dp.put(key, 1);
        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> ndp = new HashMap<>();
            for (int b : mp.keySet()) {
                for (int a : adj.getOrDefault(b, new ArrayList<>())) {
                    ndp.put(b, (ndp.getOrDefault(b, 0) + dp.getOrDefault(a, 0)) % mod);
                }
            }
            dp = ndp;
        }

        int res = 0;
        for (int val : dp.values()) res = (res + val) % mod;
        return res;
    }

    public int colorTheGrid(int m, int n) {
        return solve(m, n);
    }
}