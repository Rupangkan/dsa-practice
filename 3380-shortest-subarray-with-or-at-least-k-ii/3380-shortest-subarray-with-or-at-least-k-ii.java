class Solution {
    void updateBits(int[] bits, int no, int d) {
        for (int i = 0; i < 32; i++) {
            if (((no >> i) & 1) != 0) {
                bits[i] += d;
            }
        }
    }

    int convert(int[] bits) {
        int res = 0;
        for(int i = 0; i<32; i++) {
            if(bits[i] != 0) {
                res |= 1<< i;
            }
        }
        return res;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, l = 0, r = 0, n = nums.length, curr = 0;
        int[] bits =  new int[32];

        while(r<n) {
            updateBits(bits, nums[r], 1);
            
            while(l<=r && convert(bits) >= k) {
                ans = Math.min(ans, r-l+1);
                updateBits(bits, nums[l], -1);
                l++;
            }
           
            r++;
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}