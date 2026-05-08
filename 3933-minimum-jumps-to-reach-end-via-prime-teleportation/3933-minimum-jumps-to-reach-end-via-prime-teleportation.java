class Solution {

    static final int N = 1_000_001;
    static final List<Integer>[] pf = new ArrayList[N];

    static {
        for (int i = 0; i < N; i++) pf[i] = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (pf[i].isEmpty()) {
                for (int j = i; j < N; j += i) {
                    pf[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int p : pf[nums[i]]) {
                g.computeIfAbsent(p, z -> new ArrayList<>()).add(i);
            }
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;

        List<Integer> q = new ArrayList<>();
        q.add(0);

        int step = 0;

        while (true) {
            List<Integer> nq = new ArrayList<>();

            for (int x : q) {
                if (x == n - 1) return step;

                if (x > 0 && !vis[x - 1]) {
                    vis[x - 1] = true;
                    nq.add(x - 1);
                }

                if (x + 1 < n && !vis[x + 1]) {
                    vis[x + 1] = true;
                    nq.add(x + 1);
                }

                if (pf[nums[x]].size() == 1) {
                    int p = nums[x];

                    if (g.containsKey(p)) {
                        for (int y : g.get(p)) {
                            if (!vis[y]) {
                                vis[y] = true;
                                nq.add(y);
                            }
                        }
                        g.get(p).clear();
                    }
                }
            }

            q = nq;
            step++;
        }
    }
}