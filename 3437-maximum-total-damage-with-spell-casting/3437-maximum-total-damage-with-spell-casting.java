class Solution {
    public long maximumTotalDamage(int[] p) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int x : p) mp.put(x, mp.getOrDefault(x, 0) + 1);
        List<int[]> v = new ArrayList<>();
        v.add(new int[]{-1_000_000_000, 0});
        for (var e : mp.entrySet()) v.add(new int[]{e.getKey(), e.getValue()});
        int n = v.size(), j = 1;
        long[] dp = new long[n];
        long mx = 0, res = 0;
        for (int i = 1; i < n; i++) {
            while (j < i && v.get(j)[0] < v.get(i)[0] - 2) mx = Math.max(mx, dp[j++]);
            dp[i] = mx + 1L * v.get(i)[0] * v.get(i)[1];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
