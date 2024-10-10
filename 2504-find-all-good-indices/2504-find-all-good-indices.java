class Solution {

    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int currIdx = 0;
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        List<Integer> ans = new ArrayList<>();

        int count = 1;
        nonInc[0] = 1;

        for(int i = 1; i<n; i++) {
            nonInc[i] = count;
            if(nums[i] <= nums[i-1]) {
                count++;
            } else {
                count = 1;
            }
        }

        count = 1;
        nonDec[n-1] = 1;

        for(int i = n-2; i>=0; i--) {
            nonDec[i] = count;
            if(nums[i] <= nums[i+1]) count++;
            else count = 1;
        }

        for(int i = k; i<n-k; i++) {
            if(nonInc[i] >= k && nonDec[i] >= k) {
                ans.add(i);
            }    
        }
        return ans;
    }
}