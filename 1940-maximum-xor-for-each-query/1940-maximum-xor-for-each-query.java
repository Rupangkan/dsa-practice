class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int power = (int)Math.pow(2, maximumBit)-1, n = nums.length;
        int[] ans = new int[n];
        int xor = 0;
        for(int i = 0; i<n; i++) {
            xor ^= nums[i];
        }
        ans[0] = xor^power;
        int x = 1, r = n-1;
        while(x<n) {
            xor = xor^nums[r--];
            ans[x] = xor^power;
            x++;
        }
        return ans;
    }
}