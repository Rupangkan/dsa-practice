class Solution {

    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int[] p : points) freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);

        long ans = 0, prev = 0;

        for (int cnt : freq.values()) {
            long cur = (long) cnt * (cnt - 1) / 2;  // choose 2
            ans = (ans + cur * prev) % MOD;
            prev = (prev + cur) % MOD;
        }
        return (int) ans;
    }
}
