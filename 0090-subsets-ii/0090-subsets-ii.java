class Solution {
    private void test(int idx, int[] nums, Set<List<Integer>> set, List<Integer> temp) {
        if(idx == nums.length) {
            Collections.sort(temp);
            set.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        test(idx+1, nums, set, temp);
        temp.remove(temp.size()-1);
        test(idx+1, nums, set, temp);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        test(0, nums, set, temp);

        for(List<Integer> a: set) {
            ans.add(a);
        }
        return ans;
    }
}