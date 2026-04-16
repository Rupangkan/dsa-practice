class Solution {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] L = new int[n], R = new int[n];

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = -n; i < n; i++) {
            int idx = (i % n + n) % n;
            if (i >= 0) {
                L[i] = mp.getOrDefault(nums[i], i - n);
            }
            mp.put(nums[idx], i);
        }

        mp.clear();
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (i < n) {
                R[i] = mp.getOrDefault(nums[i], i + n);
            }
            mp.put(nums[i % n], i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : queries) {
            if (x - L[x] == n) ans.add(-1);
            else ans.add(Math.min(x - L[x], R[x] - x));
        }

        return ans;
    }
}