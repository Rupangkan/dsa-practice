class Solution {

    private void swap(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start<end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                idx = i-1;
                break;
            }
        }
        // 1 3 2 5 4 3 2
        if(idx == -1) {
            reverse(nums, 0, n-1);
        } else {
            for(int i = n-1; i>idx; i--) {
                if(nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
            reverse(nums, idx + 1, n-1);
        }
    }
}