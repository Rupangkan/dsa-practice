class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = 0;
        int count = 0;

        for(int i = 0; i<n; i++) {
            if(count == 0) {
                ele1 = nums[i];
                count++;
            } else {
                if(ele1 != nums[i]) {
                    count--;
                } else {
                    count++;
                }
            }
        }

        int c1 = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == ele1) c1++;
        }

        if(c1 > n/2) return ele1;
        return -1;
    }
}