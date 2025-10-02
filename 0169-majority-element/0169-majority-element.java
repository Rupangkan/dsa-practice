class Solution {
    private int brute(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            int currCount = 0;
            int curr = nums[i];
            for(int j = i; j<n; j++) {
                if(curr == nums[j]) currCount++;
            }
            if(currCount > n/2) return curr;
        }
        return -1;
    }
    
    public int majorityElement(int[] nums) {
        return brute(nums);
    }
}