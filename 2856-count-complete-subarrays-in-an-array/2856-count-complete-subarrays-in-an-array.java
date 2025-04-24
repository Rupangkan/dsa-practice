class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length, r = 0;
        int need = (int) Arrays.stream(nums).distinct().count();

        for (int l = 0; l < n; l++) {
            if (l > 0) {
                int rem = nums[l - 1];
                freq.put(rem, freq.get(rem) - 1);
                if (freq.get(rem) == 0) freq.remove(rem);
            }
            while (r < n && freq.size() < need) {
                int add = nums[r++];
                freq.put(add, freq.getOrDefault(add, 0) + 1);
            }
            if (freq.size() == need) ans += n - r + 1;
        }
        return ans;
    }
}