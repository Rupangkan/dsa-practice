class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i<n-2; i++) {
            int m = i + 1;
            int h = n-1;
            while(m<h) {
                int sum = nums[i] + nums[m] + nums[h];
                if(sum == 0) ans.add(Arrays.asList(nums[i], nums[m], nums[h]));
                if(sum < 0) m++;
                else h--;
            }
        }
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }
}