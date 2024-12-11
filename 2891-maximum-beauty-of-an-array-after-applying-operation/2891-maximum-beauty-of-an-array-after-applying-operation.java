class Solution {
    int findUpper(int[] arr, int val) {
        int l = 0, h = arr.length - 1, ans = 0;

        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(arr[mid] <= val) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0, n = nums.length;

        for(int i = 0; i<n; i++) {
            int upper = findUpper(nums, nums[i] + 2 * k);
            max = Math.max(max, upper - i + 1);
        }

        return max;
    }
}