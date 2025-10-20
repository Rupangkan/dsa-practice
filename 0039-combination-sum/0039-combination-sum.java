class Solution {
    private void test(int idx, int t, int[] can, List<Integer> temp, List<List<Integer>> ans) {
        if(idx == can.length) {
            if(t == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
     
        if(can[idx] <= t) {
            temp.add(can[idx]);
            test(idx, t - can[idx], can, temp, ans);
            temp.remove(temp.size()-1);
        }
        test(idx + 1, t, can, temp, ans);
    }

    public List<List<Integer>> combinationSum(int[] can, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        test(0, t, can, new ArrayList<>(), ans);
        return ans;
    }
}