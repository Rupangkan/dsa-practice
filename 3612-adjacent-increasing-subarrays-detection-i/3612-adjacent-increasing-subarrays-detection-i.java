class Solution {

    boolean inc(List<Integer> nums, int s, int k) {
        for(int i = s; i<s+k-1; i++) {
            if(nums.get(i) >= nums.get(i+1)) return false;
        }    
        return true;
    }
    
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size(), kCount1 = 0, kCount2 = 0;

        for(int i = 0; i<=n-2*k; i++) {
            boolean fInc = inc(nums, i, k);
            boolean sInc = inc(nums, i+k, k);

            if(fInc && sInc) return true;
        }

        return false;

    }
}