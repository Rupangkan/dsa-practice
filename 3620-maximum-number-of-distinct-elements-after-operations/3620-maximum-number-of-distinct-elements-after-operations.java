public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, last = Integer.MIN_VALUE;
        for (int x : nums) {
            int val = Math.min(x + k, Math.max(x - k, last + 1));
            if (val > last) {
                res++;
                last = val;
            }
        }
        return res;
    }
}