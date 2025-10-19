class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int k = i + 1;
            int l = n - 1;

            while(k < l) {
                int sum = nums[i];
                sum += nums[k];
                sum += nums[l];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[k], nums[l]));
                    k++;
                    l--;
                    while(k < l && nums[k] == nums[k-1]) k++;
                    while(k < l && nums[l] == nums[l+1]) l--;
                } else if(sum < 0) {
                    k++;
                } else {
                    l--;
                }
            }
        }
        return ans;
    }
}