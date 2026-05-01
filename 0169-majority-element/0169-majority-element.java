class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = -1, count = 0;

        for(int i = 0; i<n; i++) {
            if(count == 0) {
                ele = nums[i];
                count++;
            } else if(ele != nums[i]) {
                count--;
            } else if(ele == nums[i]) {
                count++;
            }
        }
        return ele;
    }
}