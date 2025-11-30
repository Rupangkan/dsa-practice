class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total = (total + x) % p;

        int need = total % p;
        if (need == 0) return 0;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int pref = 0, ans = n;
        for (int i = 0; i < n; i++) {
            pref = (pref + nums[i]) % p;

            int want = (pref - need + p) % p;
            if (mp.containsKey(want)) {
                ans = Math.min(ans, i - mp.get(want));
            }

            mp.put(pref, i);
        }

        return ans == n ? -1 : ans;
    }
}
