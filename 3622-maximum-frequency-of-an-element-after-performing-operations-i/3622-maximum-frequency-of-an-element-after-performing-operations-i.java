class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0, n = nums.length, ans = 0;
        for(int i = 0; i<n; i++) {
            max = Math.max(nums[i], max);
        }
        int size = max + k + 2;
        int[] pre = new int[size];
        int[] freq = new int[size];

        for(int num: nums) {
            freq[num]++;
        }
        pre[0] = freq[0];

        for(int i = 1; i<size; i++) {
            pre[i] = pre[i-1] + freq[i];
        }

        for(int i = 0; i<size; i++) {
            if(freq[i] == 0 && numOperations == 0) continue;
            int l = Math.max(0, i-k), r = Math.min(size - 1, i + k);
            int total = pre[r];
            if(l > 0) {
                total -= pre[l-1];
            } 
            int c = total - freq[i];
            int t = freq[i] + Math.min(numOperations, c);
            ans = Math.max(ans, t);
        }

        return ans;
    }
}