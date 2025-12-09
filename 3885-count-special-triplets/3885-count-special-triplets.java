class Solution {

    static final int MOD = 1000000007;

    public int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], z -> new ArrayList<>()).add(i);
        }

        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int want = nums[i] << 1;
            List<Integer> lst = mp.get(want);
            if (lst == null) continue;
            if (lst.get(0) >= i) continue;

            int[] lr = getBounds(lst, i);
            int L = lr[0], R = lr[1];
            if (nums[i] == 0) L--;

            ans = (ans + 1L * L * R) % MOD;
        }

        return (int) ans;
    }

    private int[] getBounds(List<Integer> a, int x) {
        int l = 0, r = a.size() - 1;
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            if (a.get(m) <= x) l = m;
            else r = m - 1;
        }
        return new int[]{l + 1, a.size() - 1 - l};
    }
}
