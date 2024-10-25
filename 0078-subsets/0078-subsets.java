class Solution {
    void solve(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr, int n) {
        res.add(new ArrayList<>(curr));

        for(int i = idx; i<n; i++) {
            curr.add(nums[i]);
            solve(i+1, nums, res, curr, n);
            curr.remove(curr.size() - 1);
        }
    }

    void solvePowerSet(int[] nums, List<List<Integer>> res, List<Integer> curr) {
        int n = nums.length;
        int powerEnd = 1<<n;
        
        for(int i = 0; i<powerEnd; i++) {
            List<Integer> currList = new ArrayList<>();
            int currVal = i;
            for(int j = 0; j<n; j++) {
                if((currVal&1) == 1) currList.add(nums[j]);
                currVal = currVal>>1;
            }
            res.add(new ArrayList<>(currList));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        // solve(0, nums, res, curr, nums.length);
        solvePowerSet(nums, res, curr);
        return res;
    }
}