class Solution {
    private void swap(int[] nums, int id1, int id2) {
        int temp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}