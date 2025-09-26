class Solution {
    public void sortColors(int[] nums) {
        int zeroC = 0, oneC = 0, twoC = 0, n = nums.length;

        for(int i = 0; i<n; i++) {
            if(nums[i] == 0) zeroC++;
            else if(nums[i] == 1) oneC++;
            else twoC++;
        }

        int idx = 0;
        while(zeroC > 0) {
            nums[idx] = 0;
            zeroC--;
            idx++;
        }
        while(oneC > 0) {
            nums[idx] = 1;
            oneC--;
            idx++;
        }
        while(twoC > 0) {
            nums[idx] = 2;
            twoC--;
            idx++;
        }
    }
}