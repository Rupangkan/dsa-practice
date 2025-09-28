class Solution {
    // nums[mid] == 1 --> mid++
    // nums[mid] == 0 --> swap(low, mid), mid++, low++;
    // nums[high] == 2 --> swap(high, mid), high--;
    private void swap(int[] nums, int ind1, int ind2) {
        int t = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = t;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        while(mid<=high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, high, mid);
                high--;
            }
        }
    }
}