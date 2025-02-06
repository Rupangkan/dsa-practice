class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length, ans = 0;
        HashMap<Integer, Integer> p = new HashMap<>();

        for(int i = 0; i<n; i++) {
            for(int j = i + 1; j<n; j++) {
                p.put(nums[i] * nums[j], p.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        for(int pV: p.keySet()) {
            int pF = p.get(pV);
            int pE = ((pF - 1) * pF) / 2;
            ans += 8 * pE;
        }
        return ans;
    }
}