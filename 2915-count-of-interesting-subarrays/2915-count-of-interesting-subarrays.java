class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size(), pref = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        long ans = 0;

        count.put(0, 1);
        for(int i = 0; i<n; i++) {
            pref += nums.get(i) % modulo == k ? 1 : 0;
            ans += count.getOrDefault((pref - k + modulo) % modulo, 0);
            count.put(pref % modulo, count.getOrDefault(pref % modulo, 0) + 1); 
        }
        return ans;
    }
}