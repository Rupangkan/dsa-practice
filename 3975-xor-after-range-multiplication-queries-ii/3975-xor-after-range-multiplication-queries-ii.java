class Solution {

    private static final int M = 1_000_000_007;

    private int modPow(long a, long b) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) == 1) r = r * a % M;
            a = a * a % M;
            b >>= 1;
        }
        return (int) r;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n);

        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < B; i++) g.add(new ArrayList<>());

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k < B) {
                g.get(k).add(new int[]{l, r, v});
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)(nums[i] * 1L * v % M);
                }
            }
        }

        long[] d = new long[n + B];

        for (int k = 1; k < B; k++) {
            if (g.get(k).isEmpty()) continue;

            Arrays.fill(d, 1);

            for (int[] q : g.get(k)) {
                int l = q[0], r = q[1], v = q[2];
                d[l] = d[l] * v % M;
                int R = ((r - l) / k + 1) * k + l;
                d[R] = d[R] * modPow(v, M - 2) % M;
            }

            for (int i = k; i < n; i++) {
                d[i] = d[i] * d[i - k] % M;
            }

            for (int i = 0; i < n; i++) {
                nums[i] = (int)(nums[i] * d[i] % M);
            }
        }

        int ans = 0;
        for (int x : nums) ans ^= x;

        return ans;
    }
}