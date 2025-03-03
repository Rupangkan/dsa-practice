class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int l1 = 0, n = nums.length, g1 = n - 1;
        int[] ans = new int[nums.length];

        for(int i = 0, j = n - 1; i<n; i++, j--) {
            if(nums[i] < pivot) {
                ans[l1] = nums[i];
                l1++;
            }
            if(nums[j] > pivot) {
                ans[g1] = nums[j];
                g1--;
            }
        }

        while(l1 <= g1) {
            ans[l1] = pivot;
            l1++;
        }
        
        return ans;
    }
}