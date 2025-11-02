class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = -1, count = 0;
        for(int i = 0; i<n; i++) {
            if(count == 0) {
                ele1 = nums[i];
                count++;
            } else if(nums[i] != ele1) {
                count--;
            } else if(nums[i] == ele1) count++;
        }
        return ele1;
    }
}