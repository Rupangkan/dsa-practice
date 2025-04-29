class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ind = new ArrayList<>();
        long ans = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == max) {
                ind.add(i);
            }
            int freq = ind.size();
            if(freq >= k) {
                ans += ind.get(freq - k) + 1;
            }
        }

        return ans;
    }
}