class Solution {
    public long countBadPairs(int[] nums) {
        long ans = 0, n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i<n; i++) {
            int d = i - nums[i];
            int good = count.getOrDefault(d, 0);
            ans += i - good;
            count.put(d, good + 1);
        }

        return ans;
    }
}