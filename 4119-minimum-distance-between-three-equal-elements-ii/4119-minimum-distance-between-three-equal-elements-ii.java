class Solution {

    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] nxt = new int[n];
        Arrays.fill(nxt, -1);

        Map<Integer, Integer> mp = new HashMap<>();
        int res = n + 1;

        for (int i = n - 1; i >= 0; i--) {
            if (mp.containsKey(nums[i])) {
                nxt[i] = mp.get(nums[i]);
            }
            mp.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int j = nxt[i];
            if (j == -1) continue;

            int k = nxt[j];
            if (k == -1) continue;

            res = Math.min(res, k - i);
        }

        return res == n + 1 ? -1 : res << 1;
    }
}