class Solution {
    // Better
    // O n! * n 
    // O n * n
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

    private void optimal(int idx, int n, int[] nums, List<List<Integer>> ans) {
        if(idx == n) {
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i<n; i++) {
                t.add(nums[i]);
            }
            ans.add(new ArrayList<>(t));
            return;
        }

        for(int i = idx; i<n; i++) {
            swap(i, idx, nums);
            optimal(idx+1, n, nums, ans);
            swap(i, idx, nums);
        }
    }

    private void swap(int ind1, int ind2, int[] nums) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n+1];
        // test(n, nums, ans, new ArrayList<>(), freq);
        optimal(0, n, nums, ans);
        return ans;
    }
}