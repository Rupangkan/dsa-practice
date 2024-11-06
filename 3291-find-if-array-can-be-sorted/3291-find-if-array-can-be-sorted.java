class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n-1) {
            int a = Integer.bitCount(nums[i]);
            int b = Integer.bitCount(nums[i+1]);

            if(a == b && nums[i] > nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                if(i-1 >= 0) {
                    i--;
                    continue;
                }
            }
            i++;
        }

        for(i = 0; i<n-1; i++) {
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }
}