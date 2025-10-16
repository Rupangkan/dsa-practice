class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i+1;
            int h = n-1;

            while(l<h) {
                int sum = 0;
                sum+=nums[i];
                sum+=nums[l];
                sum+=nums[h];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    l++;
                    h--;
                    while(l<h && nums[l] == nums[l-1]) l++;
                    while(l<h && nums[h] == nums[h+1]) h--;
                } else if(sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return ans;
    }
}