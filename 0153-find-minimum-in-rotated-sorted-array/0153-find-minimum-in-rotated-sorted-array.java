class Solution {
    public int findMin(int[] nums) {
        int h = nums.length - 1;
        int l = 0;

        int min = Integer.MAX_VALUE;

        while(l<=h) {
            int mid = (l+h)/2;
            if(nums[l]<=nums[mid]) {
                min = Math.min(nums[l], min);
                l = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                h = mid - 1;
            }
        }

        return min;
    }
}