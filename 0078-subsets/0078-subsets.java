class Solution {
    void solve(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr, int n) {
        res.add(new ArrayList<>(curr));

        for(int i = idx; i<n; i++) {
            curr.add(nums[i]);
            solve(i+1, nums, res, curr, n);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(0, nums, res, curr, nums.length);
        return res;
    }
}