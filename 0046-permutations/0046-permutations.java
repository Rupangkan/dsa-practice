class Solution {

    private void test(int n, int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] freq) {
        if(temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i<n; i++) {
            if(!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                test(n, nums, ans, temp, freq);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n+1];
        test(n, nums, ans, new ArrayList<>(), freq);
        return ans;
    }
}