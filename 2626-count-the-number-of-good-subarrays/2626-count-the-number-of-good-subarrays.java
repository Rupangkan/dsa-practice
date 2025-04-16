class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length, s = 0, r = -1;
        HashMap<Integer, Integer> count = new HashMap<>();

        long res = 0;

        for(int i =0; i<n; i++) {
            while(s < k && r + 1 < n) {
                r++;
                s += count.getOrDefault(nums[r], 0);
                count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            }
            if(s >= k) res += n - r;
            count.put(nums[i], count.get(nums[i]) - 1);
            s -= count.get(nums[i]);
        }

        return res;
    }
}